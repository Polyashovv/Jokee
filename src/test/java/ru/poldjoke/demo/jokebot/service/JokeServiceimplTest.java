package ru.poldjoke.demo.jokebot.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.poldjoke.demo.jokebot.repository.JokesRepository;

import static org.junit.jupiter.api.Assertions.*;

class JokeServiceimplTest {

    private JokesRepository jokesRepository = Mockito.mock(JokesRepository.class);
    private final JokeServiceimpl jokeService = new JokeServiceimpl();

    @DisplayName("Test register new joke")
    @Test
    void registerJoke() {
    }

    @Test
    void getAllJokes() {
    }

    @Test
    void getJokeById() {
    }

    @Test
    void deleteJokeById() {
    }

    @Test
    void getRandomJoke() {
    }

    @Test
    void updateJokeById() {
    }
}