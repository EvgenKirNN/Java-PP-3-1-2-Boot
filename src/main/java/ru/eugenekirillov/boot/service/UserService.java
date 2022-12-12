package ru.eugenekirillov.boot.service;

import ru.eugenekirillov.boot.model.User;

import java.util.List;

public interface UserService {

    List<User> list();

    User get(long id);

    void add(User user);

    User delete(long id);

    void update(User user);

}
