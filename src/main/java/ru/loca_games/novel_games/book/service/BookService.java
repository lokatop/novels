package ru.loca_games.novel_games.book.service;

import ru.loca_games.novel_games.book.model.Book;
import ru.loca_games.novel_games.book.model.dto.BookDto;

public interface BookService {

    Iterable<Book> getAll();

    Book get(Integer id);

    Book addBook(BookDto bookDto);
}
