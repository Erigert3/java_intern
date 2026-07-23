import java.util.ArrayList;
import java.util.Scanner;

public class Survey {

    private String title;
    private String topic;
    private String description;
    private ArrayList<Question> questions;

    public Survey(String title, String topic, String description, ArrayList<Question> questions) {
        this.title = title;
        this.topic = topic;
        this.description = description;
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public String getTopic() {
        return topic;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "title='" + title + '\'' +
                ", topic='" + topic + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

