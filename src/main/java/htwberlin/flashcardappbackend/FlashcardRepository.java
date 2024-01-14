package htwberlin.flashcardappbackend;

import htwberlin.flashcardappbackend.entities.Flashcard;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlashcardRepository extends CrudRepository<Flashcard, Long> {
    /*
    List<Flashcard> findAllByOrderByTopicAsc();
    List<Flashcard> findAllByOrderBySubjectAsc();
    List<Flashcard> findAllByOrderByRatingAsc();
    List<Flashcard> findAll(Sort sort);

     */
}
