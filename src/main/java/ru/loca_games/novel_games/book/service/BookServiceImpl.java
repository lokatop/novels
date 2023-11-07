package ru.loca_games.novel_games.book.service;

import org.springframework.stereotype.Service;
import ru.loca_games.novel_games.book.exception.BookNotFoundException;
import ru.loca_games.novel_games.book.model.Book;
import ru.loca_games.novel_games.book.model.dto.BookDto;
import ru.loca_games.novel_games.book.repository.BookRepo;

@Service
public class BookServiceImpl implements BookService{
    final BookRepo bookRepo;

    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Iterable<Book> getAll() {
        return bookRepo.findAll();
    }

    @Override
    public Book get(Integer id) {
        return bookRepo.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public Book addBook(BookDto bookDto) {
        return bookRepo.save(new Book(null, bookDto.getName(), bookDto.getDescription(), bookDto.getAuthor()));
    }
}
