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
            "SELECT * FROM students;";

    private static final String SQL_FIND_BY_FULL_NAME =
            "SELECT * FROM students where first_name = ? and last_name = ?;";

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
        StudDomain studDomain;// = new StudDomain();
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID);
             ResultSet resultSet = statement.executeQuery()) {
            statement.setLong(1, id);
            if (!resultSet.next()) {
                return null;
            } else {
                studDomain = new StudDomain(resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"),
                        resultSet.getLong("student_id"),
                        resultSet.getDate("enrolment_date").toLocalDate());
            }
        } catch (SQLException e) {
            throw new DaoException("StudDomain with this id is not found", e);
        }
        return studDomain;
    }

    @Override
    public StudDomain findByFullName(String firstName, String lastName) throws DaoException {
        StudDomain studDomain;// = new StudDomain();
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_FULL_NAME);
             ResultSet resultSet = statement.executeQuery()) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            if (!resultSet.next()) {
                return null;
            } else {
                studDomain = new StudDomain(resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"),
                        resultSet.getLong("student_id"),
                        resultSet.getDate("enrolment_date").toLocalDate());
            }
        } catch (SQLException e) {
            throw new DaoException("Can't find such studDomain", e);
        }
        return studDomain;
    }

    @Override
    public List<StudDomain> list() throws DaoException {
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SHOW_LIST);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                do {
                    StudDomain studDomain = new StudDomain(resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("email"),
                            resultSet.getString("phone_number"),
                            resultSet.getLong("student_id"),
                            resultSet.getDate("enrolment_date").toLocalDate());
                    list.add(studDomain);
                } while (resultSet.next());
            }
        } catch (SQLException e) {
            throw new DaoException("List of studDomains is empty", e);
        }
        return list;
    }

    @Override
    public StudDomain create(StudDomain studDomain) throws DaoException {
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT_STUDENT, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, studDomain.getFirstName());
            statement.setString(2, studDomain.getLastName());
            statement.setString(3, studDomain.getEmail());
            statement.setString(4, studDomain.getPhoneNumber());
            statement.setDate(5, Date.valueOf(studDomain.getEnrolmentDate()));
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException("Can't create a new studDomain", e);
        }
        return studDomain;
    }

    @Override
    public StudDomain update(StudDomain studDomain) throws DaoException {
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_STUDENT)) {
            statement.setString(1, studDomain.getFirstName());
            statement.setString(2, studDomain.getLastName());
            statement.setString(3, studDomain.getEmail());
            statement.setString(4, studDomain.getPhoneNumber());
            statement.setDate(5, Date.valueOf(studDomain.getEnrolmentDate()));
            statement.setLong(6, studDomain.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Can't update this studDomain", e);
        }
        return studDomain;
    }

    @Override
    public void delete(StudDomain studDomain) throws DaoException {
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_STUDENT)) {
            statement.setLong(1, studDomain.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Can't delete such studDomain", e);
        }
    }
}
