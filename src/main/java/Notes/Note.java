package Notes;

import Notes.Organizable;

import java.util.Date;

public class Note implements Organizable {
    private String fileName;

    private int fileID;

    private String content;

    public Note(String fileName,int fileID, Date date, String content) {
        this.fileName = fileName;
        this.fileID = fileID;
        this.content = content;
    }

    // Implement methods from the Organizable interface
    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }
    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }
}