package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAll();
    void addUser(User user);
    void deleteUser(long id);
    User getUser(long id);
    User updateUser(User user);
}
