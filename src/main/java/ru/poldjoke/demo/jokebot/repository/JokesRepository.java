package ru.poldjoke.demo.jokebot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.poldjoke.demo.jokebot.model.Joke;

public interface JokesRepository extends JpaRepository<Joke, Long> {
    // Пагинация для получения всех шуток
    Page<Joke> findAll(Pageable pageable);

    // Пагинация для топ-5 по популярности (сортируем по количеству JokeVisitor)
    Page<Joke> findByOrderByJokeVisitorDesc(Pageable pageable);
}
