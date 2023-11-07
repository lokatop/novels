package ru.loca_games.novel_games.user.service;

import ru.loca_games.novel_games.user.model.User;

public interface UserService {
    User createUser(User user);

    User get(Integer id);

    Iterable<User> getAll();
}
