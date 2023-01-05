package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDaoImpl;
import web.model.User;

@Service
public class UserServiceImpl implements UserService {
    private UserDaoImpl userDao;

    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public Object getAll() {
        return  userDao.getAll();
    }

    public User getUser(long id) {
        return  userDao.getUser(id);
    }

    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }
}
