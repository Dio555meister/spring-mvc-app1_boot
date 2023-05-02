package ru.spring.course.springmvcapp1_boot.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.course.springmvcapp1_boot.models.User;
import ru.spring.course.springmvcapp1_boot.repositories.UserRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository peopleRepository) {

        this.userRepository = peopleRepository;
    }

    @Override
    public List<User> index() {

        return userRepository.index();
    }

    @Override
    public User show(int id) {
        return userRepository.show(id);
    }

    @Override
    @Transactional
    public void save(User person) {
        userRepository.save(person);
    }

    @Override
    @Transactional
    public void update(int id, User person) {
        userRepository.update(id, person);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userRepository.delete(id);
    }
}
