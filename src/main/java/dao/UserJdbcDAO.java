package dao;

import model.User;
import utils.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDAO {
    private Connection connection;

    public UserJdbcDAO() {
        DBHelper.getInstance();
        connection = DBHelper.getConnection();
    }

    public void saveUser(User user) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user(login, password, name, role) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.executeUpdate();
        }
    }

    public User getUserById(long id) throws SQLException {
        User result;
        try (PreparedStatement pst = connection.prepareStatement("SELECT * FROM user WHERE id = ?")) {
            pst.setLong(1, id);
            ResultSet rst = pst.executeQuery();
            rst.next();
            result = new User(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4));
            rst.close();
        }
        return result;
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> result = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
            while (resultSet.next()) {
                result.add(new User(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
            }
            resultSet.close();
        }
        return result;
    }

    public void updateUser(User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE user SET login = ?, password = ?, name = ?, role = ? WHERE id = ?")) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.setLong(5, user.getId());
            preparedStatement.execute();
        } catch (Exception e) {
                    e.printStackTrace();
        }
    }

    public void deleteUser(User user) throws SQLException {
        try (PreparedStatement pst = connection.prepareStatement("DELETE FROM user WHERE login = ?")) {
            pst.setString(1, user.getLogin());
            pst.executeUpdate();
        }
    }

    public User getUserByLogin(String login) throws SQLException {
        return null;
    }
}
