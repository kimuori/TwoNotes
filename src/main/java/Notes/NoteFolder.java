package Notes;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.*;

public class NoteFolder extends NoteAbstract implements Organizable {

    private String name;
    public int index;
    private List<Note> folder; // Notes and subfolders


    public NoteFolder(String name, List<Note> folder, int index) {
        this.name = name;
        this.folder = folder;
        this.index = index;
    }
    public String getName() {
        return name;
    }

    @Override
    public void setName(String Name) {

    }

    public void setName(String name, int index) {
        this.name = name;

    }

    public List<Note> getFolder() {
        if(folder == null) {
            return folder = Collections.emptyList();
        }
        else {
            return folder;
        }
    }

    public void setFolder(ObservableList<Note> folder) {
        this.folder = folder;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


}