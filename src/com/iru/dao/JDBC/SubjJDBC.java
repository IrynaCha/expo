package com.iru.dao.JDBC;

import com.iru.dao.DaoException;
import com.iru.dao.DaoFactory;
import com.iru.dao.SubjDao;
import com.iru.domain.SubjDomain;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjJDBC implements SubjDao {
    private DaoFactory daoFactory;

    private static final String FIND_BY_ID =
            "SELECT * FROM subject where id = ?";

    private static final String FIND_ALL =
            "SELECT * FROM subject";

    private static final String CREATE_SUBJECT =
            "INSERT INTO subject(name) VALUES (?)";

    private static final String UPDATE_SUBJECT =
            "UPDATE subject SET name = ? WHERE id = ?";

    private static final String DELETE_SUBJECT =
            "DELETE FROM subject WHERE id = ?";

    public SubjJDBC(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public SubjDomain findById(Long id) throws DaoException {
        SubjDomain subjDomain = null;
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                subjDomain = mapFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException("Can't find this subjDomain", e);
        }
        return subjDomain;
    }

    @Override
    public List<SubjDomain> findAll() throws DaoException {
        List<SubjDomain> list = new ArrayList<>();
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                do {
                    SubjDomain subjDomain = mapFromResultSet(resultSet);
                    list.add(subjDomain);
                } while (resultSet.next());
            }
        } catch (SQLException e) {
            throw new DaoException("List of subjDomains is empty", e);
        }
        return list;
    }

    @Override
    public SubjDomain create(SubjDomain subjDomain) throws DaoException {
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_SUBJECT, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, subjDomain.getName());
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException("Can't create a new studDomain", e);
        }
        return subjDomain;
    }

    @Override
    public SubjDomain update(SubjDomain subjDomain) throws DaoException {
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_SUBJECT)) {
            statement.setString(1, subjDomain.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Can't update this subjDomain", e);
        }
        return subjDomain;
    }

    @Override
    public void delete(SubjDomain subjDomain) throws DaoException {
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_SUBJECT)) {
            statement.setLong(1, subjDomain.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Can't delete this subjDomain", e);
        }
    }

    private SubjDomain mapFromResultSet(ResultSet resultSet)throws SQLException{
        return new SubjDomain(resultSet.getString("name"));
    }
}
