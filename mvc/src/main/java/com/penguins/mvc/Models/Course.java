package com.penguins.mvc.Models;

public class Course {
    private int id;
    private String title;
    private String description;
    private int duration;

    public Course(int id, String title, String description, int duration) {
        setId(id);
        setTitle(title);
        setDescription(description);
        setDuration(duration);
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    
}
