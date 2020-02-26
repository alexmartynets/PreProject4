package service;

import dao.UserDAO;
import dao.UserHibernateDAO;
import factory.UserDaoFactory;
import model.User;
import utils.DBHelper;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private static UserService instance;
    private UserService() {}

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public UserDAO getQLForDao() {
        return new UserDaoFactory().getQLForDAO();
    }

    public void saveUser(User user) throws SQLException {
        UserDAO userDAO = getQLForDao();
        userDAO.saveUser(user);
    }

    public User getUserById(long id) throws SQLException {
        UserDAO userDAO = getQLForDao();
        return userDAO.getUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        UserDAO userDAO = getQLForDao();
        return userDAO.getAllUsers();
    }

    public void updateUser(User user) {
        UserDAO userDAO = getQLForDao();
        userDAO.updateUser(user);
    }

    public void deleteUser(User user) throws SQLException {
        UserDAO userDAO = getQLForDao();
        userDAO.deleteUser(user);
    }

    public User getUserByLogin (String login) throws SQLException {
        UserDAO userDAO = getQLForDao();
        return userDAO.getUserByLogin(login);
    }
}
