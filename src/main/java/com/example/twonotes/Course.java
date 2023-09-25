package com.example.twonotes;

import java.util.ArrayList;
import java.util.List;

public class Course implements Organizable {
    private String name;
    private List<Organizable> items; // Note folders

    public Course(String name) {
        this.name = name;
        this.items = new ArrayList<>();
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

    // Methods for adding and retrieving note folders
    public void addFolder(NoteFolder folder) {
        items.add(folder);
    }

    public List<Organizable> getItems() {
        return items;
    }
}