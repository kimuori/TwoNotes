package Notes;

import Notes.Organizable;

import java.util.Date;

public class Note implements Organizable {
    private String name;
    private Date date;
    private String content;

    public Note(String name, Date date, String content) {
        this.name = name;
        this.date = date;
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
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}