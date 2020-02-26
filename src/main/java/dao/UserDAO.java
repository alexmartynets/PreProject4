package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    void saveUser (User user) throws SQLException;
    void updateUser(User user);
    void deleteUser(User user) throws SQLException;
    User getUserByLogin(String login) throws SQLException;
    User getUserById (long id) throws SQLException;
    List<User> getAllUsers() throws SQLException;
}


