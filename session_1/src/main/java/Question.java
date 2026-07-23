import java.util.Date;

public class Question {

    private String question;
    private Date submissionDate;
    private Date deletionDate;

    public Question(String question, Date submissionDate, Date deletionDate) {
        this.question = question;
        this.submissionDate = submissionDate;
        this.deletionDate = deletionDate;
    }

    public String getQuestion() {
        return question;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public Date getDeletionDate() {
        return deletionDate;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public void setDeletionDate(Date deletionDate) {
        this.deletionDate = deletionDate;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", submissionDate=" + submissionDate +
                ", deletionDate=" + deletionDate +
                '}';
    }
}




