package com.mcqs.anita.mcqs_android_version1;

/**
 * Created by david-MCQS on 08/09/2015.
 */
public class QuestionOptions {

    private boolean correctAnswer;//true - correct
    private String answer;

    public QuestionOptions(){

    }
    public QuestionOptions(String answer, boolean correctAnswer){
        this.answer = answer;
        this.correctAnswer = correctAnswer;
    }
    public QuestionOptions(boolean correctAnswer){
        this.correctAnswer = correctAnswer;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }



}
