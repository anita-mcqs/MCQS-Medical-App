package com.mcqs.anita.mcqs_android_version1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by david-MCQS on 08/09/2015.
 */
public class QuestionXMLHandler extends DefaultHandler {

    boolean currentElement = false;
    String currentValue = "";

    String background;
    String question;
    String core;
    String explanation;
    QuestionOptions myAnswer;
    ArrayList<QuestionOptions> myOptions;

    public String getBackground(){
        return background;
    }
    public String getQuestion(){
        return question;
    }
    public String getCore(){
        return core;
    }
    public String getExplanation(){
        return explanation;
    }
    public ArrayList<QuestionOptions> getMyOptions(){
        return myOptions;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
        currentElement=true;

        if(qName.equals("mcqs")){
            myOptions = new ArrayList<QuestionOptions>();
        }
        else if(qName.equals("incorrectAnswer")){
            myAnswer = new QuestionOptions(false);
        }
        else if(qName.equals("correctAnswer")){
            myAnswer = new QuestionOptions(true);
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = false;

        if (qName.equalsIgnoreCase("background")) {
            background = currentValue.trim();
        }
        else if (qName.equalsIgnoreCase("question")) {
            question = currentValue.trim();
        }
        else if (qName.equalsIgnoreCase("core")) {
            core = currentValue.trim();
        }
        else if (qName.equalsIgnoreCase("explanation")) {
            explanation = currentValue.trim();
        }
        else if(qName.equalsIgnoreCase("incorrectAnswer")||qName.equalsIgnoreCase("correctAnswer")){
            myAnswer.setAnswer(currentValue.trim());
            myOptions.add(myAnswer);
        }

        currentValue="";

    }
    public void characters(char[] ch, int start, int length)
            throws SAXException {

        if (currentElement) {
            currentValue = currentValue + new String(ch, start, length);
        }

    }
}
