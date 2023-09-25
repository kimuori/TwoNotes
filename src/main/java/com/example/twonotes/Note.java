package com.example.twonotes;

public class Note implements Organizable {
    private String name;
    private String content;

    public Note(String name, String content) {
        this.name = name;
        this.content = content;
    }

    // Implement methods from the Organizable interface
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }
}