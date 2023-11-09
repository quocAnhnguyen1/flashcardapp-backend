package htwberlin.flashcardappbackend.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fach;
    private String thema;
    private String frage;
    private String antwort;
    private int rating;

    public Flashcard() {};

    public Flashcard (String fach, String thema, String frage, String antwort, int rating) {
        this.fach = fach;
        this.thema = thema;
        this.frage = frage;
        this.antwort = antwort;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFach() {
        return fach;
    }

    public void setFach(String fach) {
        this.fach = fach;
    }

    public String getThema() {
        return thema;
    }

    public void setThema(String thema) {
        this.thema = thema;
    }

    public String getFrage() {
        return frage;
    }

    public void setFrage(String frage) {
        this.frage = frage;
    }

    public String getAntwort() {
        return antwort;
    }

    public void setAntwort(String antwort) {
        this.antwort = antwort;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flashcard flashcard = (Flashcard) o;
        return rating == flashcard.rating && Objects.equals(id, flashcard.id) && Objects.equals(fach, flashcard.fach) && Objects.equals(thema, flashcard.thema) && Objects.equals(frage, flashcard.frage) && Objects.equals(antwort, flashcard.antwort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fach, thema, frage, antwort, rating);
    }

    @Override
    public String toString() {
        return "Flashcard{" +
                "id=" + id +
                ", fach='" + fach + '\'' +
                ", thema='" + thema + '\'' +
                ", frage='" + frage + '\'' +
                ", antwort='" + antwort + '\'' +
                ", rating=" + rating +
                '}';
    }
}
