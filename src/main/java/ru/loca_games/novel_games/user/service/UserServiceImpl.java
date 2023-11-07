package ru.loca_games.novel_games.user.service;

import org.springframework.stereotype.Service;
import ru.loca_games.novel_games.user.exception.UserNotFoundException;
import ru.loca_games.novel_games.user.model.User;
import ru.loca_games.novel_games.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User get(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }
}
