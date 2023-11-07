package ru.loca_games.novel_games.user.exception;

import ru.loca_games.novel_games.common.exception.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {

    public UserNotFoundException(Object id) {
        super(id, "UserService");
    }
}
