package my.first.app.rest.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="notes")
public class Diary {
    @Id
    @GeneratedValue
    private long id;
    private String topic, description;

    public Diary(long id, String topic, String description) {
        this.id = id;
        this.description = description;
        this.topic = topic;
    }

    public Diary() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
