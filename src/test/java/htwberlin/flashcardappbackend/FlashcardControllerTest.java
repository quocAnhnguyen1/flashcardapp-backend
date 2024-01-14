package htwberlin.flashcardappbackend;

import htwberlin.flashcardappbackend.entities.Flashcard;
import htwberlin.flashcardappbackend.services.FlashcardService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FlashcardControllerTest {

    @Test
    public void testCreateFlashcard() {
        // Mock FlashcardRepository
        FlashcardRepository flashcardRepository = mock(FlashcardRepository.class);

        // Create a sample flashcard
        Flashcard flashcardToSave = new Flashcard(1L, "Test Subject", "Test Topic", "Test Question", "Test Answer", 5, false);

        // Mock the save method to return the flashcard with an ID
        when(flashcardRepository.save(any(Flashcard.class))).thenReturn(
                new Flashcard(1L, "Test Subject", "Test Topic", "Test Question", "Test Answer", 5, false)
        );

        // Create FlashcardService with the mocked repository
        FlashcardService flashcardService = new FlashcardService();

        // Call the createFlashcard method
        Flashcard createdFlashcard = flashcardService.save(flashcardToSave);

        // Check if the flashcard was created successfully
        assertNotNull(createdFlashcard.getId());
        assertEquals("Test Subject", createdFlashcard.getSubject());
        assertEquals("Test Topic", createdFlashcard.getTopic());
        assertEquals("Test Question", createdFlashcard.getQuestion());
        assertEquals("Test Answer", createdFlashcard.getAnswer());
        assertEquals(5, createdFlashcard.getRating());
    }

}

