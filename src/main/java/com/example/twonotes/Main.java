package com.example.twonotes;

import Notes.NoteFolder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This application allows users to create, open, or
 * delete folders or text files,and users can
 * overwrite existing text files.
 * Main class is the main program to run the TwoNotes GUI
 *
 * @author Mohammed, Collin, Madeline, Jet, Jemina
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 901, 452);
        stage.setTitle("TwoNotes");
        stage.setScene(scene);
        stage.setResizable(false); //prevents window resizing
        stage.show();

        String userHomeDirectory = System.getProperty("user.home");
        String newFolderDirectory = userHomeDirectory.concat("\\") + "TwoNotes";
        Path path = Paths.get(newFolderDirectory);
        Files.createDirectories(path);

    }

    public static void main(String[] args) {
        launch();
    }

}