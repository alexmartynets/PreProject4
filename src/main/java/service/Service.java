package service;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface Service {
    void saveUser(User user) throws SQLException;
    User getUserById(long id) throws SQLException;
    List<User> getAllUsers() throws SQLException;
    void updateUser(User user);
    void deleteUser(User user) throws SQLException;
    User getUserByLogin (String login) throws SQLException;
}
