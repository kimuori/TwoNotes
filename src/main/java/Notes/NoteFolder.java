package Notes;

import java.util.Collections;
import java.util.List;

public class NoteFolder extends NoteAbstract implements Organizable {

    private String name;
    public int index;
    private List<Note> folder; // Notes and subfolders


    public NoteFolder(String name, List<Note> folder, int index) {
        this.name = name;
        this.folder = folder;
        this.index = index;
        //String str = "C://Users/Jemina/Folder1";
        //String str2 = "{user.dir}" + "Folder1";

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

    public void setFolder(List<Note> folder) {
        this.folder = folder;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;

    }


}