package ru.poldjoke.demo.jokebot.service;

import ru.poldjoke.demo.jokebot.model.Joke;

import java.util.List;
import java.util.Optional;

public interface JokeService {
    void registerJoke(Joke joke);
    List<Joke> getAllJokes();
    Optional <Joke> getJokeById(Long id);
    boolean deleteJokeById(Long id);
    Joke getRandomJoke();
    void updateJokeById(Long id, Joke updatedJoke);


}
