package ru.poldjoke.demo.jokebot.repository;

import org.springframework.data.repository.CrudRepository;
import ru.poldjoke.demo.jokebot.model.User;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
