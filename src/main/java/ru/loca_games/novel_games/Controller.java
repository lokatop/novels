package ru.loca_games.novel_games;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.loca_games.novel_games.book.model.Book;
import ru.loca_games.novel_games.book.model.dto.BookDto;
import ru.loca_games.novel_games.book.service.BookService;
import ru.loca_games.novel_games.user.model.User;
import ru.loca_games.novel_games.user.service.UserService;

import javax.validation.Valid;

@RestController
@Validated
@AllArgsConstructor
@RequestMapping(value = "/novel", produces =  "application/json")
public class Controller {

    final BookService bookService;
    final UserService userService;

    @GetMapping(path = "/books")
    public Iterable<Book> getBooks() {
        return bookService.getAll();
    }

    @GetMapping(path = "/books/{id}")
    public Book getBooks(@PathVariable Integer id) {
        return bookService.get(id);
    }

    @PostMapping(path = "/books")
    public Book addBook(@RequestBody @Valid BookDto bookDto) {
        return bookService.addBook(bookDto);
    }

    @GetMapping(path = "/users")
    public Iterable<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping(path = "/users/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.get(id);
    }

    @PostMapping(path = "/users/random")
    public User createRandomUser() {
        User user = new User();
        user.setName("name" + Math.random());
        user.setChatId("chat_id" + Math.random()); //It's telegram chat_id for future
        return userService.createUser(user);
    }

}
