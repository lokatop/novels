package ru.loca_games.novel_games.book.repository;

import org.springframework.data.repository.CrudRepository;
import ru.loca_games.novel_games.book.model.Book;

public interface BookRepo extends CrudRepository<Book, Integer> {
}
