package ru.eugenekirillov.boot.dao;

import ru.eugenekirillov.boot.model.User;

import java.util.List;

public interface UserDao {

    List<User> list();

    User get(long id);

    void add(User user);

    User delete(long id);

    void update(User user);
}