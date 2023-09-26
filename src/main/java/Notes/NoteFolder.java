package Notes;

import Notes.Organizable;

import java.util.ArrayList;
import java.util.List;

public class NoteFolder implements Organizable {
    private String name;
    private List<Organizable> items; // Notes and subfolders

    public NoteFolder(String name) {
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

    // Methods for adding and retrieving items (Notes or subfolders)
    public void addItem(Organizable item) {
        items.add(item);
    }

    public List<Organizable> getItems() {
        return items;
    }
}