package com.mcqs.anita.mcqs_android_version1;


/**
 * Created by david-MCQS on 07/09/2015.
 */
public class Question {

    private int index;
    private String background;
    private String question;
    private QuestionOptions[] questionOptions = new QuestionOptions[5];
    private String core;
    private String explanation;
    private String imagePath;



    public Question(){
        //default constructor
    }
    public Question(QuestionOptions[] questionOptions, String background, String question, String core, String explanation){
        this.questionOptions = questionOptions;
        this.background = background;
        this.question = question;
        this.core = core;
        this.explanation=explanation;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public QuestionOptions[] getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(QuestionOptions[] questionOptions) {
        this.questionOptions = questionOptions;
    }


    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
