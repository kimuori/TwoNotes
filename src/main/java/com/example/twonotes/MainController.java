package com.example.twonotes;


import Notes.Note;
import Notes.NoteFolder;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.io.*;
import java.io.IOException;
import Notes.Note;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.stage.FileChooser;


import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;


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

    FileChooser filechooser = new FileChooser();
  
    @FXML
    ListView<String> noteListView;
  
    @FXML
    Button deleteFolderButton;
  
    @FXML
    ListView<String> addFolderListView;
  
    @FXML
    Button addFolderButton;
  
    @FXML
    private TextArea fileConent;

    @FXML
    private TextField fileTitle;
  
    @FXML
    private Button saveNoteButton;

    /**
     * addNoteButtonOnAction method is called when "Add Note" button is clicked. It will
     * create a test file and the user can choose its name. The note content
     * will show up in the local UI.
     *
     * @author Madeline, Jemina, Jet
     * @param event
     */
    @FXML
    public void addNoteButtonOnAction(ActionEvent event) {
        // ADDED: This prevents textArea/textField overlapping whenever user opens/creates a text file
        fileConent.clear();
        fileTitle.clear();
        System.out.println("Dashboard is cleared");
        // Extension filter is added to restrict the selection to create text files only
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File selectedFile = fileChooser.showSaveDialog(stage); // Open a Save dialog
        
        int index2 =1;
        Note note = new Note("Note " + index2, index2);
        noteListView.getItems().add(note.getName());
        index2++;
        if (selectedFile != null) { // Checks if a file was selected

        selectedFile = fileChooser.showSaveDialog(stage); // Open a save dialog
        // console update where a text file is created
        System.out.println("\nText file created = " + selectedFile.getAbsolutePath() + "\n");

        // Checks if a file was selected; it will write a default string into the text file.
        if (selectedFile != null) {
            try {
                String content = "Write content here!"; // initial default text
                writeTextToFile(selectedFile, content); // method to write content on the text file
                // ADDED: Changes properties on the saveNoteButton and fileContent
                fileConent.setEditable(true); // allows TextArea editable
                saveNoteButton.setDisable(false); // makes save button accessible
            } catch (IOException e) {
                e.printStackTrace(); // Stack trace is printed to the console if error occurs during file creation or writing process
            }
        }
        // NOTE: Added functionality based on open_File method to show the created file to the local UI.
        try  {
            Scanner scan = new Scanner(selectedFile); // scans the file that has been created above
            Scanner scanTitle = new Scanner(selectedFile.getName()); //scans the file's name

            aNote = new Note(scanTitle.toString()); //stores the new note instantiation to the Note object

            // reads the fine name line
            while (scanTitle.hasNextLine()){
                fileTitle.appendText(scanTitle.nextLine());
            }

            // reads the text file content each line
            while (scan.hasNextLine()){
                fileConent.appendText(scan.nextLine() + "\n");
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        //debugging
        //String textAreaContent = fileConent.getText();
        // (!(textAreaContent.isEmpty())){
        //    System.out.println("TextArea not empty? true");
        //}
    }

    /**
     * writeTextToFile method takes in params file & content.
     * It uses the BufferedWriter class to write the content to the file
     * and ensures the file is closed correctly.
     *
     * @author Madeline
     * @param filePath, content
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
     * @param event
     */
    @FXML
    private void saveNoteButtonOnAction (ActionEvent event) throws IOException{
        File textFilePath= selectedFile; //current path the user is using the text file
        // gathers text content even the new lines
        String content = fileConent.getText().replaceAll("\n", System.getProperty("line.separator"));

        writeTextToFile(textFilePath, content); // method to buffer write the content

        System.out.println("Successfully wrote to the file.");
    }

    /**
     * open_File method is called when "Open a File" is clicked from the upper left corner.
     * This gives the user to traverse through the directory and select a text file.
     * The textfile will show up in the local UI.
     *
     * @author Jet
     * @param actionEvent
     */
    @FXML
    public void open_File(ActionEvent actionEvent) {
        // ADDED: This prevents textArea/textField overlapping whenever user opens/creates a text file
        fileConent.clear();
        fileTitle.clear();
        System.out.println("Dashboard is cleared");
        // Extension filter is added to restrict the selection to open text files only
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        selectedFile = fileChooser.showOpenDialog(new Stage());
        // console update where a text file is opened
        System.out.println( "\nText file opened = " + selectedFile.getAbsolutePath() + "\n");

        if (selectedFile != null) {
            // ADDED: Changes properties on the saveNoteButton and fileContent
            fileConent.setEditable(true); // allows TextArea editable
            saveNoteButton.setDisable(false); // makes save button accessible
        }

        try  {
            Scanner scan = new Scanner(selectedFile);
            Scanner scanTitle = new Scanner(selectedFile.getName());

            aNote = new Note(scanTitle.toString()); // stores opened note instantiation to the Note object

            // reads the fine name line
            while (scanTitle.hasNextLine()){
                fileTitle.appendText(scanTitle.nextLine());
            }

            // reads the text file content each line
            while (scan.hasNextLine()){
                fileConent.appendText(scan.nextLine() + "\n");
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        // debugging
        //String textAreaContent = fileConent.getText();
        //if (!(textAreaContent.isEmpty())){
        //    System.out.println("TextArea not empty? true");
        //}
    }

    /**
     *
     * @author Jet
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
        filechooser.setInitialDirectory(new File("C:\\Users"));
    }
      
    @FXML
    public void addFolderOnAction(ActionEvent event)  {
        NoteFolder noteFolder = new NoteFolder("Note Folder " + addFolderListView.getEditingIndex(), null, addFolderListView.getEditingIndex());
        addFolderListView.getItems().add(noteFolder.getName());

    @FXML
    public void deleteFolderOnAction(ActionEvent event) {
        String index = addFolderListView.getSelectionModel().getSelectedItem();
        addFolderListView.getItems().remove(index);
    }
      
}