package Notes;

import Notes.Organizable;

import java.util.Date;

public class Note implements Organizable {
    private String name;

    private int noteID;

    private String content;



    public Note(String name, int noteID, Date date, String content) {
        this.name = name;
        this.noteID = noteID;
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
    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }
}