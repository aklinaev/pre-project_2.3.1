package web.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    private final EntityManager manager;

    public UserDaoImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<User> getAll() {
        return manager.createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Override
    public void addUser(User user) {
        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();
    }

    @Override
    public void deleteUser(long id) {
        manager.getTransaction().begin();
        User userToDel = manager.find(User.class, id);
        manager.remove(userToDel);
        manager.getTransaction().commit();
    }

    @Override
    public User getUser(long id) {
        return manager.find(User.class, id);
    }

    @Override
    public User updateUser(User user) {
        manager.getTransaction().begin();
        User updatedUser = manager.merge(user);
        manager.getTransaction().commit();
        return updatedUser;
    }


}
