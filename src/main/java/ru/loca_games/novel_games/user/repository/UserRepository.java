package ru.loca_games.novel_games.user.repository;

import org.springframework.data.repository.CrudRepository;
import ru.loca_games.novel_games.user.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
