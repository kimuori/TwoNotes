package com.example.twonotes;

import java.io.*;
import java.io.IOException;

import Notes.Note;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import javafx.stage.FileChooser;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MainController implements Initializable {
    private Stage stage;
    FileChooser filechooser = new FileChooser();

    @FXML
    private TextArea fileConent;

    @FXML
    private TextField fileTitle;

    /**
     * addNoteButtonOnAction method is called when "Add Note" button is clicked. It will
     * create a test file and the user can choose its name. The note content
     * will show up in the local UI.
     *
     * @author Jemina, Madeline, Jet
     * @param event
     */
    @FXML
    public void addNoteButtonOnAction(ActionEvent event) {
        // FileChooser used to open a file dialog for the user to specify a file name & location within the directory
        FileChooser fileChooser = new FileChooser();
        // Extension filter is added to restrict the selection to txt files only
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File selectedFile = fileChooser.showSaveDialog(stage); // Open a Save dialog
        // Checks if a file was selected; it will write a default string into the text file.
        if (selectedFile != null) {
            try {
                String content = "Write content here!.";
                writeTextToFile(selectedFile, content); //method to write content on the text file
            } catch (IOException e) {
                e.printStackTrace(); // Stack trace is printed to the console if error occurs during file creation or writing process
            }
        }
        // NOTE: Added functionality based on open_File method to show the created file to the local UI.
        try  {
            Scanner scan = new Scanner(selectedFile); // scans the file that has been created above
            Scanner scanTitle = new Scanner(selectedFile.getName()); //scans the file's name

            Note aNote = new Note(scanTitle.toString()); //stores the new note instantiation to the Note object

            //reads the fine name line
            while (scanTitle.hasNextLine()){
                fileTitle.appendText(scanTitle.nextLine());
            }

            //reads the text file content each line
            while (scan.hasNextLine()){
                fileConent.appendText(scan.nextLine() + "\n");
            }

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
     * @param file, content
     */
    private void writeTextToFile(File file, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        }
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
        File file = filechooser.showOpenDialog(new Stage());

        try  {
            Scanner scan = new Scanner(file);
            Scanner scanTitle = new Scanner(file.getName());

            //reads the fine name line
            while (scanTitle.hasNextLine()){
                fileTitle.appendText(scanTitle.nextLine());
            }

            //reads the text file content each line
            while (scan.hasNextLine()){
                fileConent.appendText(scan.nextLine() + "\n");
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }


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
    public void initialize (URL location, ResourceBundle resources) {
        filechooser.setInitialDirectory(new File("C:\\Users"));
    }


}