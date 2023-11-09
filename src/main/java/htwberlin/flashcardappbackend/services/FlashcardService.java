package htwberlin.flashcardappbackend.services;

import htwberlin.flashcardappbackend.FlashcardRepository;
import htwberlin.flashcardappbackend.entities.Flashcard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlashcardService {


    @Autowired
    FlashcardRepository repo;

    public Flashcard save (Flashcard flashcard) {
        return repo.save(flashcard);
    }

    public Flashcard get(Long id) {
        return repo.findById(id).orElseThrow(()-> new RuntimeException());
    }

    public List<Flashcard> getAll(){
        Iterable<Flashcard> iterator = repo.findAll();
        List<Flashcard> flashcards = new ArrayList<Flashcard>();
        for (Flashcard flashcard : iterator)  flashcards.add(flashcard);
        return flashcards;
    }

}
