package com.iru.dao.JDBC;

import com.iru.dao.DaoException;
import com.iru.dao.DaoFactory;
import com.iru.dao.RoomDao;
import com.iru.domain.RoomDomain;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomJDBC implements RoomDao {
    private DaoFactory daoFactory;

    private static final String FIND_BY_ID =
            "SELECT * FROM room WHERE id = ?";

    private static final String FIND_ALL =
            "SELECT * FROM room";

    private static final String CREATE_ROOM =
            "INSERT INTO room(number) VALUES (?)";

    private static final String UPDATE_ROOM =
            "UPDATE room SET number = ? WHERE id = ?";

    private static final String DELETE_ROOM =
            "DELETE FROM room WHERE id = ?";

    public RoomJDBC(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public RoomDomain findById(Long id) throws DaoException {
        RoomDomain roomDomain = null;
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                roomDomain = mapFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException("Can't find this roomDomain", e);
        }
        return roomDomain;
    }

    @Override
    public List<RoomDomain> findAll() throws DaoException {
        List<RoomDomain> list = new ArrayList<>();
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                do {
                    RoomDomain roomDomain = mapFromResultSet(resultSet);
                    list.add(roomDomain);
                } while (resultSet.next());
            }
        } catch (SQLException e) {
            throw new DaoException("List of roomDomains is empty", e);
        }
        return list;
    }

    @Override
    public RoomDomain create(RoomDomain roomDomain) throws DaoException {
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_ROOM, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, roomDomain.getNumber());
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException("Can't create a new roomDomain", e);
        }
        return roomDomain;
    }

    @Override
    public RoomDomain update(RoomDomain roomDomain) throws DaoException {
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ROOM)) {
            statement.setString(1, roomDomain.getNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Can't update this roomDomain", e);
        }
        return roomDomain;
    }

    @Override
    public void delete(RoomDomain roomDomain) throws DaoException {
        try (Connection connection = daoFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ROOM)) {
            statement.setLong(1, roomDomain.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Can't delete this roomDomain", e);
        }
    }

    private RoomDomain mapFromResultSet(ResultSet resultSet) throws SQLException {
        return new RoomDomain(resultSet.getString("number"));
    }
}
