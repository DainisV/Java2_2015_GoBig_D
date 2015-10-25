package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.GroupDAO;
import lv.javaguru.java2.domain.Group;
import lv.javaguru.java2.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Viktor on 01/07/2014.
 */
public class GroupDAOImpl extends DAOImpl implements GroupDAO {

    @Override
    public void create(Group group) throws DBException {
        if (group == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into USERS values (default, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, group.getName());
            preparedStatement.setString(2, group.getDescription());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                group.setGroupId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute GroupDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    @Override
    public Group getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from GROUPS where UserID = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Group group = null;
            if (resultSet.next()) {
                group = new Group();
                group.setGroupId(resultSet.getLong("GroupID"));
                group.setName(resultSet.getString("GroupName"));
                group.setDescription(resultSet.getString("GroupDescription"));
            }
            return group;
        } catch (Throwable e) {
            System.out.println("Exception while execute GroupDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Group> getAll() throws DBException {
        List<Group> groups = new ArrayList<Group>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from GROUPS");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Group group = new Group();
                group.setGroupId(resultSet.getLong("GroupID"));
                group.setName(resultSet.getString("GroupName"));
                group.setDescription(resultSet.getString("GroupDescription"));
                groups.add(group);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list GroupDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return groups;
    }

    @Override
    public void delete(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from GROUPS where GroupID = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute GroupDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Group group) throws DBException {
        if (group == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update GROUPS set Name = ?, Description = ? " +
                            "where GroupID = ?");
            preparedStatement.setString(1, group.getName());
            preparedStatement.setString(2, group.getDescription());
            preparedStatement.setLong(3, group.getGroupId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute GroupDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

}
