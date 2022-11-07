package my.first.app.rest.models;

import javax.persistence.*;
import java.time.LocalDateTime;

/*
 * Реализация модели "Заметки"
 */
@Entity(name = "Note")
@Table(name="notes")
public class Note {

    public Note(long id, String topic, String description, LocalDateTime date) {
        this.id = id;
        this.description = description;
        this.topic = topic;
        this.date = date;
    }

    public Note() {

    }

    @Id
    @Column(name="id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "topic")
    private String topic;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "date")
    private LocalDateTime date;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
