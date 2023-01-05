package web.service;

import web.model.User;

public interface UserService {
    public void addUser(User user);
    public Object getAll();
    public User getUser(long id);
    public User updateUser(User user);
    public void deleteUser(long id);
}
