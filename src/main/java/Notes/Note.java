package Notes;

import Notes.Organizable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Note extends NoteAbstract implements Organizable {
    private String name;
    private int noteID;



    private String noteContent;



    public Note(String name, int noteID, String noteContent) {
        this.name = name;
        this.noteID = noteID;
        //String str = "text.txt";
        //String str2 = "Folder1";
        //String str3 = "C://Users/Jemina/Folder1/text.txt";
        this.noteContent = noteContent;
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
  
    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
        this.noteContent = noteContent;
    }
    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    //public String getContent(){return content;}
    //public void setContent(String content){this.content = content;}
    //public int getNoteID() {return noteID;}
    //public void setNoteID(int noteID) {this.noteID = noteID;}
}