package my.first.app.DemoRest.models;

public class Diary {
    private Integer id;
    private String description;

    public Diary(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Diary() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
