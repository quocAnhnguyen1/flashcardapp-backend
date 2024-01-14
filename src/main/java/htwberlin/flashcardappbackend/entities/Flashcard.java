package htwberlin.flashcardappbackend.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private String topic;
    private String question;
    private String answer;
    private int rating;

    public Flashcard(long l, String testSubject, String testTopic, String testQuestion, String testAnswer, int i, boolean b) {};

    public Flashcard (String subject, String topic, String question, String answer, int rating) {
        this.subject = subject;
        this.topic = topic;
        this.question = question;
        this.answer = answer;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
        return rating == flashcard.rating && Objects.equals(id, flashcard.id) && Objects.equals(subject, flashcard.subject) && Objects.equals(topic, flashcard.topic) && Objects.equals(question, flashcard.question) && Objects.equals(answer, flashcard.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, topic, question, answer, rating);
    }

    @Override
    public String toString() {
        return "Flashcard{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", topic='" + topic + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", rating=" + rating +
                '}';
    }
}
