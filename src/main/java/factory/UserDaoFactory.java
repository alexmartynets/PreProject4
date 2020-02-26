package factory;

import dao.UserDAO;
import dao.UserHibernateDAO;
import dao.UserJdbcDAO;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserDaoFactory {
    public UserDAO getQLForDAO() {
        Properties properties = new Properties();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("property.properties");
            assert inputStream != null;
            properties.load(inputStream);
            String DAOtypeql = properties.getProperty("DAOtypeql");
            if (DAOtypeql.equals("hql")) {
                return new UserHibernateDAO();
            } if (DAOtypeql.equals("sql")) {
                return new UserJdbcDAO();
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}