package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.DBHelper;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserHibernateDAO implements UserDAO{
    private Session session;

    public UserHibernateDAO() {
        this.session = DBHelper.getSessionFactory().openSession();
    };

    @Override
    public void saveUser(User user) {
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateUser(User user) {
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteUser(User user) {
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    @Override
    public User getUserByLogin(String login) {
        try {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
            Root<User> root = criteriaQuery.from(User.class);
            criteriaQuery.select(root);
            criteriaQuery.where(criteriaBuilder.equal(root.get("login"), login));
            Query query = session.createQuery(criteriaQuery);
            User result = (User) query.getSingleResult();
            return result;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public User getUserById(long id) {
        return session.get(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) session.createQuery("FROM User").list();
    }
}