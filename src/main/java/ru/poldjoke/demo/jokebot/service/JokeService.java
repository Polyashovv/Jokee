package ru.poldjoke.demo.jokebot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.poldjoke.demo.jokebot.model.Joke;

import java.util.Optional;

public interface JokeService {
    // Методы, принимающие Pageable
    Page<Joke> getJokes(Pageable pageable);
    Page<Joke> getTopJokes(Pageable pageable);

    // Оставляем существующие методы
    void registerJoke(Joke joke);
    Optional<Joke> getJokeById(Long id);
    boolean deleteJokeById(Long id);
    Joke getRandomJoke();
    void updateJokeById(Long id, Joke updatedJoke);
}
