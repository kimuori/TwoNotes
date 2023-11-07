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

    //private int noteCounter = 0;

    @FXML
    // Method is called when "Add Note" button is clicked
    public void addNoteButtonOnAction(ActionEvent event) {
        //noteCounter++;
        // FileChooser used to open a file dialog for the user to specify a file name & location within the directory
        FileChooser fileChooser = new FileChooser();
        // Extension filter is added to restrict the selection to txt files only
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File selectedFile = fileChooser.showSaveDialog(stage); // Open a Save dialog

        if (selectedFile != null) { // Checks if a file was selected
            try {
                String content = "Write content here!.";
                writeTextToFile(selectedFile, content); //method to write content on the text file
            } catch (IOException e) {
                e.printStackTrace(); // Stack trace is printed to the console if error occurs during file creation or writing process
            }
        }
        try  {
            Scanner scan = new Scanner(selectedFile);
            Scanner scanTitle = new Scanner(selectedFile.getName());

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

    // writeTextToFile method takes in params file & content
    // and uses the BufferedWriter class to efficiently write the content to the file
    // and also ensure the file is closed correctly
    private void writeTextToFile(File file, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        }
    }

    // Implemented by Jet Lao
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
    @Override
    public void initialize (URL location, ResourceBundle resources) {
        filechooser.setInitialDirectory(new File("C:\\Users"));
    }


}