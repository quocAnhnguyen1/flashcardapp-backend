package htwberlin.flashcardappbackend.controller;

import htwberlin.flashcardappbackend.entities.Flashcard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import htwberlin.flashcardappbackend.services.FlashcardService;

import java.util.List;

@RestController
public class FlashcardController {

    @Autowired
    FlashcardService service;

    @PostMapping("/flashcards")
    public Flashcard createFlashcard(@RequestBody Flashcard flashcard) {
        return service.save(flashcard);
    }

    @GetMapping("/flashcards/{id}")
    public Flashcard getFlashcard(@PathVariable String id) {
        Long flashcardId = Long.parseLong(id);
        return service.get(flashcardId);
    }

    @GetMapping("/flashcards")
    public List<Flashcard> getAllFlashcards() {
        return service.getAll();
    }
}

