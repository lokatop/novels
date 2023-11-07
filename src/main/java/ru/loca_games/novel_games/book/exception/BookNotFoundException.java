package ru.loca_games.novel_games.book.exception;

import ru.loca_games.novel_games.common.exception.EntityNotFoundException;

public class BookNotFoundException extends EntityNotFoundException {

    public BookNotFoundException(Object id) {
        super(id, "BookService");
    }
}
