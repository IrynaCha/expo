package com.iru.dao.JDBC;

import com.iru.dao.DaoException;
import com.iru.dao.DaoFactory;
import com.iru.dao.GrouDao;
import com.iru.domain.GrouDomain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GrouJDBC implements GrouDao {
    private DaoFactory daoFactory;

    private static final String FIND_ALL = "SELECT * FROM group";

    private static final String FIND_BY_ID = "SELECT * FROM group WHERE id = ?";

    private static final String INSERT_GROUP = "INSERT INTO group(id, department_id, name) VALUES (?, ?, ?)";

    private static final String UPDATE_GROUP = "UPDATE group SET department_id = ?, name = ? WHERE id = ?";

    private static final String DELETE_GROUP = "DELETE FROM group WHERE id = ?";

    public GrouJDBC(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public GrouDomain findById(Long id) throws DaoException {
        GrouDomain grouDomain = null;
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                grouDomain = mapFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException("Can't find such GroupDomain", e);
        }
        return grouDomain;
    }

    @Override
    public List<GrouDomain> findAll() throws DaoException {
        List<GrouDomain> list = new ArrayList<>();
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                do {
                    GrouDomain grouDomain = mapFromResultSet(resultSet);
                    list.add(grouDomain);
                } while (resultSet.next());
            }
        } catch (SQLException e) {
            throw new DaoException("List is empty", e);
        }
        return list;
    }

    @Override
    public GrouDomain create(GrouDomain grouDomain) throws DaoException {
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_GROUP, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, grouDomain.getDepartment_id());
            statement.setString(2, grouDomain.getName());
            statement.executeQuery();
        } catch (SQLException e) {
            throw new DaoException("Can't create such grouDomain", e);
        }
        return grouDomain;
    }

    @Override
    public GrouDomain update(GrouDomain grouDomain) throws DaoException {
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_GROUP)) {
            statement.setLong(1, grouDomain.getDepartment_id());
            statement.setString(2, grouDomain.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Can't update this GrouDomain", e);
        }
        return grouDomain;
    }

    @Override
    public void delete(GrouDomain grouDomain) throws DaoException {
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_GROUP)) {
            statement.setLong(1, grouDomain.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Can't find this GrouDomain", e);
        }
    }

    private GrouDomain mapFromResultSet(ResultSet resultSet) throws SQLException {
        return new GrouDomain(resultSet.getString("name"),
                resultSet.getLong("department_id"));
    }
}
