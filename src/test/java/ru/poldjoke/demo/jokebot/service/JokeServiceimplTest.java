package ru.poldjoke.demo.jokebot.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Pageable;
import ru.poldjoke.demo.jokebot.model.Joke;
import ru.poldjoke.demo.jokebot.repository.JokesRepository;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class JokeServiceimplTest {

    // Создаем замокированный репозиторий
    private JokesRepository jokesRepository = Mockito.mock(JokesRepository.class);

    // Передаем замокированный репозиторий в конструктор JokeServiceimpl
    private final JokeServiceimpl jokeService = new JokeServiceimpl(jokesRepository);

    @DisplayName("Test register new joke")
    @Test
    void registerJoke() {
        // Пример теста для регистрации шутки
        // Создаем шутку и передаем ее в сервис
        Joke joke = new Joke("Test joke", new Date());
        jokeService.registerJoke(joke);

        // Убедимся, что метод save был вызван один раз в репозитории
        Mockito.verify(jokesRepository, Mockito.times(1)).save(joke);
    }

    @Test
    void getAllJokes() {
        // Пример теста для получения всех шуток
        jokeService.getAllJokes(Pageable.unpaged()); // Получаем все шутки

        // Убедимся, что метод findAll был вызван
        Mockito.verify(jokesRepository, Mockito.times(1)).findAll();
    }

    @Test
    void getJokeById() {
        // Пример теста для получения шутки по ID
        Long jokeId = 1L;
        jokeService.getJokeById(jokeId);

        // Убедимся, что метод findById был вызван с правильным ID
        Mockito.verify(jokesRepository, Mockito.times(1)).findById(jokeId);
    }

    @Test
    void deleteJokeById() {
        // Пример теста для удаления шутки по ID
        Long jokeId = 1L;
        jokeService.deleteJokeById(jokeId);

        // Убедимся, что метод deleteById был вызван
        Mockito.verify(jokesRepository, Mockito.times(1)).deleteById(jokeId);
    }

    @Test
    void getRandomJoke() {
        // Пример теста для получения случайной шутки
        jokeService.getRandomJoke();

        // Убедимся, что метод findRandomJoke был вызван
        Mockito.verify(jokesRepository, Mockito.times(1)).findRandomJoke();
    }

    @Test
    void updateJokeById() {
        // Пример теста для обновления шутки по ID
        Long jokeId = 1L;
        Joke updatedJoke = new Joke();
        updatedJoke.setText("Updated joke text");

        jokeService.updateJokeById(jokeId, updatedJoke);

        // Убедимся, что метод findById был вызван и затем save
        Mockito.verify(jokesRepository, Mockito.times(1)).findById(jokeId);
        Mockito.verify(jokesRepository, Mockito.times(1)).save(updatedJoke);
    }
}
