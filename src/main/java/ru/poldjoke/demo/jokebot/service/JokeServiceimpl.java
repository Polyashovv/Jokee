package ru.poldjoke.demo.jokebot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.poldjoke.demo.jokebot.model.Joke;
import ru.poldjoke.demo.jokebot.repository.JokesRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class JokeServiceimpl implements JokeService {

    private final JokesRepository jokesRepository;

    @Override
    public void registerJoke(Joke joke) {
        jokesRepository.save(joke);
    }

    @Override
    public List<Joke> getAllJokes() {
        return jokesRepository.findAll();
    }

    @Override
    public Optional<Joke> getJokeById(Long id) {
        return jokesRepository.findById(id);
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
        List<Joke> jokes = jokesRepository.findAll();
        if (jokes.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(jokes.size());
        return jokes.get(randomIndex);
    }
    @Override
    public void updateJokeById(Long id, Joke updatedJoke) {
        Optional<Joke> existingJokeOptional = jokesRepository.findById(id);
        if (existingJokeOptional.isPresent()) {
            Joke existingJoke = existingJokeOptional.get();
            existingJoke.setText(updatedJoke.getText());
            existingJoke.setUpdatedAt(new Date()); // Устанавливаем текущую дату изменения
            jokesRepository.save(existingJoke); // Обновляем шутку в репозитории
        }
    }
}
