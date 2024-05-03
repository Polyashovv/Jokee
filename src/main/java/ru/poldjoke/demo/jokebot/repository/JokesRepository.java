package ru.poldjoke.demo.jokebot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.poldjoke.demo.jokebot.model.Joke;

import java.util.List;

public interface JokesRepository extends JpaRepository<Joke, Long> {
    @Query("SELECT j FROM Jokes j ORDER BY SIZE(j.jokeVisitor) DESC")
    List<Joke> findTop5ByOrderByJokeVisitorDesc();

}
