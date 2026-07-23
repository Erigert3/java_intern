import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SurveyResult {

    private Survey survey;
    private Candidate candidate;
    private Date dateTaken;
    private Map<Question, Answer> questionsWithAnswers;

    public SurveyResult(Survey survey, Candidate candidate, Date dateTaken, Map<Question, Answer> questionsWithAnswers) {
        this.survey = survey;
        this.candidate = candidate;
        this.dateTaken = dateTaken;
        this.questionsWithAnswers = questionsWithAnswers;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    public Map<Question, Answer> getQuestionsWithAnswers() {
        return questionsWithAnswers;
    }

    public void setQuestionsWithAnswers(Map<Question, Answer> questionsWithAnswers) {
        this.questionsWithAnswers = questionsWithAnswers;
    }

    public Answer findMostGivenAnswer (SurveyResult surveyResult){
        int agreeCount = 0;
        int slightlyAgreeCount = 0;
        int slightlyDisgreeCount = 0;
        int disagreeCount = 0;
        for (Answer answer : surveyResult.getQuestionsWithAnswers().values()){
            switch (answer){
                case Answer.AGREE -> agreeCount++;
                case Answer.SLIGHTLY_AGREE -> slightlyAgreeCount++;
                case Answer.SLIGHTLY_DISAGREE -> slightlyDisgreeCount++;
                case Answer.DISAGREE -> disagreeCount++;
            }
        }
        int max = Math.max(Math.max(agreeCount, slightlyAgreeCount), Math.max(disagreeCount,slightlyDisgreeCount));
        if (max == agreeCount) {
            return Answer.AGREE;
        } else if (max == slightlyAgreeCount) {
            return Answer.SLIGHTLY_AGREE;
        } else if (max == disagreeCount) {
            return Answer.DISAGREE;
        } else {
            return Answer.SLIGHTLY_DISAGREE;
        }
    }

    public String printSurveyResult (SurveyResult sr){
        int agreeCount = 0;
        int slightlyAgreeCount = 0;
        int slightlyDisgreeCount = 0;
        int disagreeCount = 0;
        for (Answer answer : sr.getQuestionsWithAnswers().values()){
            switch (answer){
                case Answer.AGREE -> agreeCount++;
                case Answer.SLIGHTLY_AGREE -> slightlyAgreeCount++;
                case Answer.SLIGHTLY_DISAGREE -> slightlyDisgreeCount++;
                case Answer.DISAGREE -> disagreeCount++;
            }
        }
        Map <String, Integer> results = new HashMap<String, Integer>();
        results.put("AGREE", agreeCount);
        results.put("SLIGHTLY AGREE", slightlyAgreeCount);
        results.put("DISAGREE", disagreeCount);
        results.put("SLIGHTLY DISAGREE", slightlyDisgreeCount);

        return "The results for Survey: " + survey.getTitle() + " taken by candidate: " +
                candidate.getFirstName() + " " + candidate.getLastName() + " are as follows: " + "\n" + results.toString();
    }



    @Override
    public String toString() {
        return "SurveyResult{" +
                "survey=" + survey +
                ", candidate=" + candidate +
                ", dateTaken=" + dateTaken +
                '}';
    }

}
