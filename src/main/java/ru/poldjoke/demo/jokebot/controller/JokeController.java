package ru.poldjoke.demo.jokebot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.poldjoke.demo.jokebot.model.Joke;
import ru.poldjoke.demo.jokebot.service.JokeService;

import java.util.Date;

@RestController
@RequestMapping("/jokes")
@RequiredArgsConstructor
public class JokeController {
    private final JokeService jokeService;

    @GetMapping
    public ResponseEntity<Page<Joke>> getJokes(Pageable pageable) {
        return ResponseEntity.ok(jokeService.getJokes(pageable));
    }

    @GetMapping("/top")
    public ResponseEntity<Page<Joke>> getTopJokes(Pageable pageable) {
        return ResponseEntity.ok(jokeService.getTopJokes(pageable));
    }

    @PostMapping
    ResponseEntity<Void> registerJoke(@RequestBody Joke joke) {
        joke.setCreatedAt(new Date());
        jokeService.registerJoke(joke);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    ResponseEntity<Joke> getJokeById(@PathVariable Long id) {
        return jokeService.getJokeById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteJokeById(@PathVariable Long id) {
        if (jokeService.deleteJokeById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<Void> updateJoke(@PathVariable Long id, @RequestBody Joke updatedJoke) {
        jokeService.updateJokeById(id, updatedJoke);
        return ResponseEntity.ok().build();
    }
}
