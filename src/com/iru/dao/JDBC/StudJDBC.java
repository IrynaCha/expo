package com.iru.dao.JDBC;

import com.iru.dao.DaoException;
import com.iru.dao.DaoFactory;
import com.iru.dao.StudDao;
import com.iru.domain.StudDomain;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudJDBC implements StudDao {
    private DaoFactory daoFactory;
    private List<StudDomain> list = new ArrayList<>();

    private static final String SQL_FIND_BY_ID =
            "SELECT * FROM students where student_id = ?;";

    private static final String SQL_SHOW_LIST =
            "SELECT student_id, first_name, last_name, email, phone_number, enrolment_date FROM students;";

    private static final String SQL_FIND_BY_FULL_NAME =
            "SELECT student_id, first_name, last_name, email, phone_number, enrolment_date FROM students where first_name = ? and last_name = ?;";

    private static final String SQL_INSERT_STUDENT =
            "INSERT INTO students(first_name, last_name, email, phone_number, enrolment_date) VALUES (?, ?, ?, ?, ?);";

    private static final String SQL_UPDATE_STUDENT =
            "UPDATE students SET first_name = ?, last_name = ?, email = ?, phone_number = ?, enrolment_date = ?::DATE WHERE student_id = ?;";

    private static final String SQL_DELETE_STUDENT =
            "DELETE FROM students WHERE student_id = ?;";

    public StudJDBC(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public StudDomain findById(Long id) throws DaoException {
        StudDomain student = new StudDomain();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement(SQL_FIND_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next() == false) {
                return null;
            } else {
                student = new StudDomain(resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("email"), resultSet.getString("phone_number"), resultSet.getLong("student_id"), resultSet.getDate("enrolment_date").toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    @Override
    public StudDomain findByFullName(String firstName, String lastName) throws DaoException {
        StudDomain student = new StudDomain();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement(SQL_FIND_BY_FULL_NAME);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            resultSet = statement.executeQuery();
            if (resultSet.next() == false) {
                return null;
            } else {
                student = new StudDomain(resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("email"), resultSet.getString("phone_number"), resultSet.getLong("student_id"), resultSet.getDate("enrolment_date").toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    @Override
    public List<StudDomain> list() throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement(SQL_SHOW_LIST);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                do {
                    StudDomain student = new StudDomain(resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("email"), resultSet.getString("phone_number"), resultSet.getLong("student_id"), resultSet.getDate("enrolment_date").toLocalDate());
                    list.add(student);
                } while (resultSet.next());
            }
        } catch (SQLException e) {
            throw new DaoException("List of students is empty", e);
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public StudDomain create(StudDomain student) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement(SQL_INSERT_STUDENT, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getEmail());
            statement.setString(4, student.getPhoneNumber());
            statement.setDate(5, Date.valueOf(student.getEnrolmentDate()));
            statement.execute();
            resultSet = statement.getGeneratedKeys();
            resultSet.next();
            student = new StudDomain(resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("email"), resultSet.getString("phone_number"), resultSet.getDate("enrolment_date").toLocalDate());
            student.setFirstName(resultSet.getString("first_name"));
            student.setLastName(resultSet.getString("last_name"));
            student.setEmail(resultSet.getString("email"));
            student.setPhoneNumber(resultSet.getString("phone_number"));
            student.setEnrolmentDate(resultSet.getDate("enrolment_date").toLocalDate());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    @Override
    public StudDomain update(StudDomain student) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE_STUDENT);
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getEmail());
            statement.setString(4, student.getPhoneNumber());
            statement.setDate(5, Date.valueOf(student.getEnrolmentDate()));
            statement.setLong(6, student.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    @Override
    public void delete(StudDomain student) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_STUDENT);
            statement.setLong(1, student.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
