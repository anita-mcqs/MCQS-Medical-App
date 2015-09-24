package com.mcqs.anita.mcqs_android_version1;

/**
 * Created by david-MCQS on 22/09/2015.
 */
public class Exam {
    private String name;
    private int id;
    private String description;

    public Exam(){

    }
    public Exam(String name, int id, String description){
        this.name = name;
        this.id = id;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
