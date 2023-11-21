package com.example.twonotes;


import Notes.Note;
import Notes.Data;
import Notes.NoteFolder;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.function.Function;

import static com.example.twonotes.Main.loadData;


/**
 * MainController class accompanies the Main.java, the class that initializes the main.fxml.
 * This controller class has the button listeners whenever the end-user interacts with the GUI program.
 *
 * @author Collin, Madeline, Jet, Jemina
 *
 */
public class MainController implements Initializable {
    private Stage stage;
    private Scene scene;

    FileChooser fileChooser = new FileChooser();

    DirectoryChooser directoryChooser = new DirectoryChooser();

    // ADDED: becomes global variable so the current text file can be used throughout the program
    File selectedFile;
    //String userHomeDirectory;
    String twoNoteDirectory;

    Note aNote;

    NoteFolder currentFolder;

    int index2 = 1;


//FileChooser filechooser = new FileChooser();

    ArrayList<NoteFolder> data = loadData.getData();




    @FXML
    ListView<String> noteListView;

    @FXML
    Button deleteFolderButton;

    @FXML
    ListView<String> addFolderListView;


    @FXML
    Button addFolderButton;

    @FXML
    private TextArea fileContent;

    @FXML
    private TextField fileTitle;

    @FXML
    private Button saveNoteButton;

    @FXML
    private Button deleteNoteButton;

    /**
     * addNoteButtonOnAction method is called when "Add Note" button is clicked. It will
     * create a test file and the user can choose its name. The note content
     * will show up in the local GUI.
     *
     * @author Madeline, Jemina, Jet, Collin
     */


    @FXML
    public void addNoteButtonOnAction(ActionEvent event) {
        // ADDED: This prevents textArea/textField overlapping whenever user opens/creates a text file
        fileContent.clear();
        fileTitle.clear();
        System.out.println("Dashboard is cleared.");
        // Extension filter is added to restrict the selection to create text files only
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        selectedFile = fileChooser.showSaveDialog(stage); // Open a Save dialog

        //NOTE: made a try-catch block to handle nullPointers and InvocationTargetException.
        try {
            // Checks if a file was selected; it will write a default string into the text file.
            if (selectedFile != null) {
                System.out.println("\nText file created = " + selectedFile.getAbsolutePath() + "\n");
                String content = "Write content here!"; // initial default text
                writeTextToFile(selectedFile, content); // method to write content on the text file
                // ADDED: Changes properties on the saveNoteButton and fileContent
                fileContent.setEditable(true); // allows TextArea editable
                saveNoteButton.setDisable(false); // makes save button accessible
                deleteNoteButton.setDisable(false); // makes delete button accessible
            } else {
                //Notifies in the console that selectedFile is null.
                System.out.println("InvocationTargetException is thrown.");
            }
        } catch (IOException e) {
            e.printStackTrace(); // Stack trace is printed to the console if error occurs during file creation or writing process
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Exception handled due to text files not being created in the FileChooser.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // NOTE: Added functionality based on open_File method to show the created file to the local GUI.
        try {
            Scanner scan = new Scanner(selectedFile); // scans the file that has been created above
            //Scanner scanTitle = new Scanner(selectedFile.getName()); //scans the file's name

            aNote = new Note(selectedFile.getName(), index2, ""); // FIXED: Bug fix to show text file name to the ListView
            index2++;
            currentFolder.getFolder().add(aNote);


            // REMOVED: while loop to read text file name
            // while (scanTitle.hasNextLine()){
            fileTitle.appendText(selectedFile.getName());
            //}

            // reads the text file content each line
            while (scan.hasNextLine()) {
                fileContent.appendText(scan.nextLine() + "\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * writeTextToFile method takes in params file & content.
     * It uses the BufferedWriter class to write the content to the file
     * and ensures the file is closed correctly.
     *
     * @param filePath Takes in File data type of the user's current disk directory.
     * @param content  Takes in String data to write to the current text file.
     * @author Madeline
     */
    private void writeTextToFile(File filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }

    /**
     * saveNoteButtonOnAction method allows to save new writes into the text file that
     * was created or opened.
     *
     * @author Jemina
     */
    @FXML
    private void saveNoteButtonOnAction(ActionEvent event) throws IOException {
        File textFilePath = selectedFile; //current path the user is using the text file
        // gathers text content even the new lines
        String content = fileContent.getText().replaceAll("\n", System.getProperty("line.separator"));

        writeTextToFile(textFilePath, content); // method to buffer write the content

        System.out.println("Successfully wrote to the file.");
    }

    /**
     * deleteNoteButtonOnAction removes the current textFile
     * that is currently being used in the dashboard.
     *
     * @param event
     * @throws IOException
     * @throws NoSuchFileException
     * @throws DirectoryNotEmptyException
     * @throws FileSystemException
     * @author Jemina
     */
    @FXML
    private void deleteNoteButtonOnAction(ActionEvent event) throws IOException, NoSuchFileException, DirectoryNotEmptyException, FileSystemException {
        /* Debugging code portion 1
        File textFilePath = selectedFile;
        textFilePath.delete();
        if (textFilePath.delete()) {
            System.out.println("Successfully deleted file.");
        } else {
            System.out.println("Failed to delete the file.");
        } */

        /* Debugging code portion 2 */
        //NOTE: this delete button does not successfuly delete the text file due to being used in another process.
        //Need a way to "close out" the text file and then delete it.
        fileContent.clear();
        fileTitle.clear();
        Path path = selectedFile.toPath();

        try {

            Files.delete(path);
            System.out.println("Successfully deleted ");
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", path);
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", path);
        } catch (IOException x) {
            // File permission problems are caught here.
            System.err.println(x);
            System.out.println("Nothing can be done.");
        }
    }

    /**
     * open_File method is called when "Open a File" is clicked from the upper left corner.
     * This gives the user to traverse through the directory and select a text file.
     * The textfile will show up in the local GUI.
     *
     * @author Jet, Jemina, Collin
     */
    @FXML
    public void open_File(ActionEvent actionEvent) {
        // ADDED: This prevents textArea/textField overlapping whenever user opens/creates a text file
        fileContent.clear();
        fileTitle.clear();
        System.out.println("Dashboard is cleared.");
        // Extension filter is added to restrict the selection to open text files only
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        selectedFile = fileChooser.showOpenDialog(new Stage());

        //NOTE: made a try-catch block to handle nullPointers and InvocationTargetException.
        try {
            // Checks if a file was opened.
            if (selectedFile != null) {
                // console update where a text file is opened
                System.out.println("\nText file opened = " + selectedFile.getAbsolutePath() + "\n");
                // ADDED: Changes properties on the saveNoteButton and fileContent
                fileContent.setEditable(true); // allows TextArea editable
                saveNoteButton.setDisable(false); // makes save button accessible
                deleteNoteButton.setDisable(false); // makes delete button accessible
            } else {
                //Notifies in the console that selectedFile is null.
                System.out.println("InvocationTargetException is thrown.");
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Exception handled due to NullPointer in the FileChooser.");

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Scanner scan = new Scanner(selectedFile);
            //Scanner scanTitle = new Scanner(selectedFile.getName());

            aNote = new Note(selectedFile.getName(), index2, "");  // FIXED: Bug fix to show text file name to the ListView
            index2++;
            noteListView.getItems().add(aNote.getName());

            // REMOVED: while loop to read text file name
            //while (scanTitle.hasNextLine()){
            fileTitle.appendText(selectedFile.getName());
            //}

            // reads the text file content each line
            while (scan.hasNextLine()) {
                fileContent.appendText(scan.nextLine() + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace(); // Stack trace is printed to the console if error occurs during file creation or writing process
        }

    }

    /**
     * addFolderOnAction creates a new folder in the user's home directory
     * and creates the name of the folder, creates List of folders, and its indices.
     *
     * @author Collin, Jemina
     */
    @FXML
    public void addFolderOnAction(ActionEvent event) throws IOException {
        NoteFolder noteFolder = new NoteFolder("NoteFolder" + (data.size()), null, data.size());
        data.add(noteFolder);
        String newFolderDirectory = twoNoteDirectory.concat("\\") + noteFolder.getName();
        Path path = Paths.get(newFolderDirectory);
        Files.createDirectories(path);
        addFolderListView.getItems().add(noteFolder.getName());
        deleteFolderButton.setDisable(false); // delete folder button is accessible


        System.out.println("Directory is created!");

        //File selectedDirectory = directoryChooser.showDialog(new Stage());
        System.out.println("Folder selected = " + path.getFileName());

    }

    /**
     * deleteFolderOnAction deletes the folder that has
     * been selected in the list view.
     *
     * @author Collin, Jemina
     */
    @FXML
    public void deleteFolderOnAction(ActionEvent event) {
        String index = addFolderListView.getSelectionModel().getSelectedItem();
        addFolderListView.getItems().remove(index);
        String toDeleteFolderDirectory = twoNoteDirectory.concat("\\") + index;

        Path path = Paths.get(toDeleteFolderDirectory);
        try {
            Files.delete(path);
            System.out.println("Successfully deleted a folder.");
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", path);
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", path);
        } catch (IOException x) {
            // File permission problems are caught here.
            System.err.println(x);
            System.out.println("Nothing can be done.");
        }
    }

    /**
     * Runs along with the GUI. This sets the initial directory at C://Users/{user.home}
     * This creates two listeners for the NoteFolder list view and the Note list view objects.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
     * @author Jet, Collin
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) throws NullPointerException {
        //userHomeDirectory = System.getProperty("user.home"); //"C://users/userName"
        twoNoteDirectory = System.getProperty("user.home").concat("\\") + "TwoNotes";
        System.out.println("Current Directory = " + twoNoteDirectory);
        fileChooser.setInitialDirectory(new File(twoNoteDirectory));

        addFolderListView.getFocusModel().focusedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                currentFolder = data.get((Integer) newValue);
                noteListView.getItems().clear();

                List<String> names = currentFolder.getFolder().stream().map(new Function<Note, String>() {
                    @Override
                    public String apply(Note note) {
                        return note.getName();
                    }
                }).toList();

                noteListView.getItems().addAll(names); //gets the current folder names (not notes)
                noteListView.getFocusModel().focusedIndexProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        Note currentNote = currentFolder.getFolder().get((Integer) newValue);
                        fileTitle.clear();
                        fileTitle.appendText(currentNote.getName());
                        fileContent.clear();
                        fileContent.appendText(currentNote.getNoteContent());

                    }
                });

            }
        });

    }

    public static boolean directoryExists(String directoryPath) {
        File directory = new File(directoryPath);
        return directory.exists() && directory.isDirectory();
    }
    public void loadList(){
        //addFolderListView.getItems().addAll(Main.loadData.getData());
    }

}
