package ru.poldjoke.demo.jokebot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.poldjoke.demo.jokebot.model.Joke;
import ru.poldjoke.demo.jokebot.service.JokeService;
import ru.poldjoke.demo.jokebot.service.TelegramBotService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jokes")
@RequiredArgsConstructor
public class JokeController {

    private final JokeService jokeService;
    private final TelegramBotService telegramBotService; // Внедряем TelegramBotService

    //POST /jokes

    @PostMapping
    ResponseEntity<Void> registerJoke(@RequestBody Joke joke){
        joke.setCreatedAt(new Date());
        jokeService.registerJoke(joke);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/top5")
    ResponseEntity<List<Joke>> getTop5PopularJokes() {
        return ResponseEntity.ok(jokeService.getTop5PopularJokes());
    }

    //GET /Jokes

    @GetMapping
    ResponseEntity<List<Joke>> getJokes(){
        return ResponseEntity.ok(jokeService.getAllJokes());
    }


    //GET jokes/id

    @GetMapping("/{id}")
    ResponseEntity<Joke> getJokeById(@PathVariable Long id){
        return jokeService.getJokeById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    // DELETE /jokes/id
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteJokeById(@PathVariable Long id) {
        if (jokeService.deleteJokeById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT /jokes/{id}
    @PutMapping("/{id}")
    ResponseEntity<Void> updateJoke(@PathVariable Long id, @RequestBody Joke updatedJoke) {
        jokeService.updateJokeById(id, updatedJoke);
        return ResponseEntity.ok().build();
    }


}
