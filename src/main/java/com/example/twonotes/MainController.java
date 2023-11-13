package com.example.twonotes;


import Notes.Note;
import Notes.NoteFolder;

import java.io.*;
import java.io.IOException;

import java.nio.file.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import java.net.URL;
import java.util.function.Function;
import java.util.stream.Collectors;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

/**
 * MainController class accompanies the Main.java, the class that initializes the main.fxml.
 * This controller class has the button listeners whenever the end-user interacts with the UI program.
 *
 * @author Mohammed, Collin, Madeline, Jet, Jemina
 *
 */
public class MainController implements Initializable {
    private Stage stage;
    private Scene scene;

    FileChooser fileChooser = new FileChooser();

    // ADDED: becomes global variable so the current text file can be used throughout the program
    File selectedFile;

    Note aNote;

    int index1 = 1;
    int index2 = 1;

    ArrayList<NoteFolder> data = new ArrayList<>();

    //FileChooser filechooser = new FileChooser();
  
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
     * will show up in the local UI.
     *
     * @author Madeline, Jemina, Jet, Collin
     *
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
        System.out.println("\nText file created = " + selectedFile.getAbsolutePath() + "\n");

        // Checks if a file was selected; it will write a default string into the text file.
        if (selectedFile != null) {
            try {
                String content = "Write content here!"; // initial default text
                writeTextToFile(selectedFile, content); // method to write content on the text file
                // ADDED: Changes properties on the saveNoteButton and fileContent
                fileContent.setEditable(true); // allows TextArea editable
                saveNoteButton.setDisable(false); // makes save button accessible
                deleteNoteButton.setDisable(false); // makes delete button accessible

            } catch (IOException e) {
                e.printStackTrace(); // Stack trace is printed to the console if error occurs during file creation or writing process
            }
        }
        // NOTE: Added functionality based on open_File method to show the created file to the local UI.
        try  {
            Scanner scan = new Scanner(selectedFile); // scans the file that has been created above
            //Scanner scanTitle = new Scanner(selectedFile.getName()); //scans the file's name

            aNote = new Note(selectedFile.getName(), index2); // FIXED: Bug fix to show text file name to the ListView
            index2++;
            noteListView.getItems().add(aNote.getName());

            // REMOVED: while loop to read text file name
            // while (scanTitle.hasNextLine()){
            fileTitle.appendText(selectedFile.getName());
            //}

            // reads the text file content each line
            while (scan.hasNextLine()){
                fileContent.appendText(scan.nextLine() + "\n");
            }

            //System.out.println("Path file content:\n" +  fileConent.getText());

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    /**
     * writeTextToFile method takes in params file & content.
     * It uses the BufferedWriter class to write the content to the file
     * and ensures the file is closed correctly.
     *
     * @author Madeline
     * @param filePath
     * Takes in File data type of the user's current disk directory.
     *
     * @param content
     * Takes in String data to write to the current text file.
     *
     */
    private void writeTextToFile (File filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }

    /**
     * saveNoteButtonOnAction method allows to save new writes into the text file that
     * was created or opened.
     *
     * @author Jemina
     *
     */
    @FXML
    private void saveNoteButtonOnAction (ActionEvent event) throws IOException{
        File textFilePath= selectedFile; //current path the user is using the text file
        // gathers text content even the new lines
        String content = fileContent.getText().replaceAll("\n", System.getProperty("line.separator"));

        writeTextToFile(textFilePath, content); // method to buffer write the content

        System.out.println("Successfully wrote to the file.");
    }

    /**
     * deleteNoteButtonOnAction removes the current textFile
     * that is currently being used in the dashboard.
     *
     * @author Jemina
     * @param event
     * @throws IOException
     * @throws NoSuchFileException
     * @throws DirectoryNotEmptyException
     * @throws FileSystemException
     */
    @FXML
    private void deleteNoteButtonOnAction (ActionEvent event) throws IOException, NoSuchFileException, DirectoryNotEmptyException, FileSystemException {
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
     * The textfile will show up in the local UI.
     *
     * @author Jet, Jemina, Collin
     *
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
        // console update where a text file is opened
        System.out.println( "\nText file opened = " + selectedFile.getAbsolutePath() + "\n");

        if (selectedFile != null) {
            // ADDED: Changes properties on the saveNoteButton and fileContent
            fileContent.setEditable(true); // allows TextArea editable
            saveNoteButton.setDisable(false); // makes save button accessible
            deleteNoteButton.setDisable(false); // makes delete button accessible
        }

        try  {
            Scanner scan = new Scanner(selectedFile);
            //Scanner scanTitle = new Scanner(selectedFile.getName());

            aNote = new Note(selectedFile.getName(), index2);  // FIXED: Bug fix to show text file name to the ListView
            index2++;
            noteListView.getItems().add(aNote.getName());

            // REMOVED: while loop to read text file name
            //while (scanTitle.hasNextLine()){
            fileTitle.appendText(selectedFile.getName());
            //}

            // reads the text file content each line
            while (scan.hasNextLine()){
                fileContent.appendText(scan.nextLine() + "\n");
            }

            //System.out.println("Path file content:\n" +  fileConent.getText());

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    /**
     *
     * @author Jet, Collin
     * @param location
     * The location used to resolve relative paths for the root object, or
     * {@code null} if the location is not known.
     *
     * @param resources
     * The resources used to localize the root object, or {@code null} if
     * the root object was not localized.
     */
    @Override
    public void initialize (URL location, ResourceBundle resources) throws NullPointerException {
        fileChooser.setInitialDirectory(new File("C:\\Users"));

        addFolderListView.getFocusModel().focusedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println(addFolderListView.getItems());
                //NoteFolder currentFolder = data.get((Integer) newValue);
                //noteListView.getItems().clear();

                //List<String> names = currentFolder.getFolder().stream().map(new Function<Note, String>() {
                    // getFolder needs to be a List not Observable at NoteFolder.java
                //    @Override
                //    public String apply(Note note) {
                //        return note.getName();
                //    }
                //}).toList();

                //noteListView.getItems().addAll(names); //gets the current folder names (not notes)
            }
        });
    }

    /**
     *
     * @author Collin
     *
     */
    @FXML
    public void addFolderOnAction(ActionEvent event){
        //NoteFolder noteFolder = new NoteFolder("Note Folder " + index1, null, index1);
        //index1++;
        NoteFolder noteFolder = new NoteFolder("Note Folder " + data.size()+1, null, data.size()+1);
        data.add(noteFolder);
        addFolderListView.getItems().add(noteFolder.getName());
        deleteFolderButton.setDisable(false); // delete folder button is accessible
    }

    /**
     *
     * @author Collin
     *
     */
    @FXML
    public void deleteFolderOnAction(ActionEvent event) {
        String index = addFolderListView.getSelectionModel().getSelectedItem();
        addFolderListView.getItems().remove(index);
    }

}