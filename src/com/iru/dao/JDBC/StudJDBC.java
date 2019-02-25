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

    private static final String FIND_BY_ID =
            "SELECT * FROM student where id = ?";

    private static final String FIND_ALL =
            "SELECT * FROM student";

    private static final String INSERT_STUDENT =
            "INSERT INTO student(first_name, last_name, email, phone_number, enrolment_date, group_id) VALUES (?, ?, ?, ?, ?, ?)";

    private static final String UPDATE_STUDENT =
            "UPDATE student SET first_name = ?, last_name = ?, email = ?, phone_number = ?, enrolment_date = ?::DATE, group_id = ? WHERE id = ?";

    private static final String DELETE_STUDENT =
            "DELETE FROM student WHERE id = ?";

    public StudJDBC(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    private StudDomain mapFromResultSet(ResultSet resultSet) throws SQLException {
        return new StudDomain(resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("email"), resultSet.getString("phone_number"), resultSet.getLong("id"), resultSet.getDate("enrolment_date").toLocalDate(), resultSet.getLong("group_id"));
    }

    @Override
    public StudDomain findById(Long id) throws DaoException {
        StudDomain studDomain = null;
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                studDomain = mapFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException("Can't find this studDomain", e);
        }
        return studDomain;
    }

    @Override
    public List<StudDomain> findAll() throws DaoException {
        List<StudDomain> list = new ArrayList<>();
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                do {
                    StudDomain studDomain = mapFromResultSet(resultSet);
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
             PreparedStatement statement = connection.prepareStatement(INSERT_STUDENT, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, studDomain.getFirstName());
            statement.setString(2, studDomain.getLastName());
            statement.setString(3, studDomain.getEmail());
            statement.setString(4, studDomain.getPhoneNumber());
            statement.setDate(5, Date.valueOf(studDomain.getEnrolmentDate()));
            statement.setLong(6, studDomain.getGroup_id());
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException("Can't create a new studDomain", e);
        }
        return studDomain;
    }

    @Override
    public StudDomain update(StudDomain studDomain) throws DaoException {
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT)) {
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
             PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT)) {
            statement.setLong(1, studDomain.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Can't delete this studDomain", e);
        }
    }
}
