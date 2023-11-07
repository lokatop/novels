package ru.loca_games.novel_games.user.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.loca_games.novel_games.book.model.Book;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JoinColumn(name = "name")
    private String name;

    @NotNull
    @JoinColumn(name = "chat_id")
    private String chatId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book lastActiveBook;

    @JoinColumn(name = "last_node_id")
    private Integer lastBookNodeId;
}
