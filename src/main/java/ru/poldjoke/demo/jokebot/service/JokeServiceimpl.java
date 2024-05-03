package ru.poldjoke.demo.jokebot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.poldjoke.demo.jokebot.model.Joke;
import ru.poldjoke.demo.jokebot.model.JokeVisitor;
import ru.poldjoke.demo.jokebot.repository.JokesRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class JokeServiceimpl implements JokeService {
    private final JokesRepository jokesRepository;

    // Метод для пагинации всех шуток
    @Override
    public Page<Joke> getJokes(Pageable pageable) {
        return jokesRepository.findAll(pageable);
    }

    // Метод для пагинации топ-5 шуток по количеству посетителей
    @Override
    public Page<Joke> getTopJokes(Pageable pageable) {
        return jokesRepository.findByOrderByJokeVisitorDesc(pageable);
    }

    @Override
    public void registerJoke(Joke joke) {
        jokesRepository.save(joke);
    }

    @Override
    public Optional<Joke> getJokeById(Long id) {
        Optional<Joke> jokeOptional = jokesRepository.findById(id);
        jokeOptional.ifPresent(joke -> {
            joke.getJokeVisitor().add(new JokeVisitor(null, joke, new Date()));
            jokesRepository.saveAndFlush(joke);
        });
        return jokeOptional;
    }

    @Override
    public boolean deleteJokeById(Long id) {
        Optional<Joke> jokeOptional = jokesRepository.findById(id);
        if (jokeOptional.isPresent()) {
            jokesRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Joke getRandomJoke() {
        return jokesRepository.findRandomJoke(); // Используем метод из репозитория
    }

    @Override
    public void updateJokeById(Long id, Joke updatedJoke) {
        Optional<Joke> existingJokeOptional = jokesRepository.findById(id);
        if (existingJokeOptional.isPresent()) {
            Joke existingJoke = existingJokeOptional.get();
            existingJoke.setText(updatedJoke.getText());
            existingJoke.setUpdatedAt(new Date());
            jokesRepository.save(existingJoke);
        }
    }
}
