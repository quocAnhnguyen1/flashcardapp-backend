package htwberlin.flashcardappbackend.controller;

import htwberlin.flashcardappbackend.entities.Flashcard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("/flashcards/{id}")
    public ResponseEntity<String> deleteFlashcard(@PathVariable Long id) {
        try {
            service.deleteFlashcard(id);
            return ResponseEntity.ok("Flashcard deleted successfully");
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting flashcard");
        }
    }
/*
    @GetMapping("/sortedByTopic")
    public List<Flashcard> getFlashcardOrderedByTopic(){
        return service.getAllOrderedByTopic();
    }
    @GetMapping("/sortedBySubject")
    public List<Flashcard> getFlashcardOrderedBySubject(){
        return service.getAllOrderedBySubject();
    }
    @GetMapping("/sortedByRating")
    public List<Flashcard> getFlashcardOrderedByRating(){
        return service.getAllOrderedByRating();
    }

    @GetMapping("/flashcards/sorted")
    public ResponseEntity<List<Flashcard>> getAllSorted(@RequestParam(required = false, defaultValue = "") List<String> sortBy) {
        System.out.println("Sorting Parameter: " + sortBy);
        List<Flashcard> flashcards = service.getAllSorted(sortBy);
        return new ResponseEntity<>(flashcards, HttpStatus.OK);
    }*/
}

