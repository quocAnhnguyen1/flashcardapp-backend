package htwberlin.flashcardappbackend.services;

import htwberlin.flashcardappbackend.FlashcardRepository;
import htwberlin.flashcardappbackend.entities.Flashcard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FlashcardService {


    @Autowired
    FlashcardRepository repo;

    public Flashcard save (Flashcard flashcard) {
        return repo.save(flashcard);
    }

    public Flashcard get(Long id) {
        return repo.findById(id).orElseThrow(()-> new RuntimeException("Flashcard with ID " + id + " not found."));
    }

    public List<Flashcard> getAll() {
        return StreamSupport.stream(repo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void deleteFlashcard(Long id){
        repo.deleteById(id);
    }
    /*
    public List<Flashcard> getAllOrderedByTopic(){
        return repo.findAllByOrderByTopicAsc();
    }
    public List<Flashcard> getAllOrderedBySubject(){
        return repo.findAllByOrderBySubjectAsc();
    }
    public List<Flashcard> getAllOrderedByRating(){
        return repo.findAllByOrderByRatingAsc();
    }

    public List<Flashcard> getAllSorted(List<String> sortBy){
        List<Sort.Order> orders = new ArrayList<>();
        for (String sortOption : sortBy) {
            switch (sortOption){
                case "subject":
                    orders.add(Sort.Order.by("subject"));
                    break;
                case "topic":
                    orders.add(Sort.Order.by("topic"));
                    break;
                case "rating":
                    orders.add(Sort.Order.by("rating"));
                    break;
            }
        }
        return repo.findAll(Sort.by(orders));
    }

     */
}
