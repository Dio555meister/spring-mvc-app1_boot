package ru.spring.course.springmvcapp1_boot.repositories;


import ru.spring.course.springmvcapp1_boot.models.User;

import java.util.List;

public interface UserRepository {
    List<User> index();

    User show(int id);

    void save(User person);

    void update(int id, User person);

    void delete(int id);

}
