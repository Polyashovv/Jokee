package ru.poldjoke.demo.jokebot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.poldjoke.demo.jokebot.model.Joke;

public interface JokesRepository extends JpaRepository<Joke, Long> {
}
