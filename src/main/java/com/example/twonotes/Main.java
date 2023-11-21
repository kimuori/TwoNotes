package com.example.twonotes;

import Notes.Data;
import Notes.Note;
import Notes.NoteFolder;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

import static com.example.twonotes.MainController.directoryExists;


/**
 * This application allows users to create, open, or
 * delete folders or text files,and users can
 * overwrite existing text files.
 * Main class is the main program to run the TwoNotes GUI
 *
 * @author Mohammed, Collin, Madeline, Jet, Jemina
 */

public class Main extends Application {
    public static Data loadData = new Data();
    @FXML
    ListView<String> addFolderListView;
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

        if (directoryExists(newFolderDirectory)) {
            System.out.println("The directory already exists");
        } else {
            Files.createDirectories(path);
        }
        try {

            ArrayList<File> noteList = new ArrayList<>();
            File file = new File(newFolderDirectory);
                    Files.walk(file.toPath()).forEach(new Consumer<Path>() {
                        @Override
                        public void accept(Path path) {
                            File file1= path.toFile();
                            if(file1.isDirectory()) {
                                NoteFolder noteFolder = new NoteFolder(file1.getName(), null, (loadData.getSize() + 1));
                                loadData.addData(noteFolder);
                            }

                            if (path.toString().endsWith(".txt")) {
                                noteList.add(path.toFile());

                            }
                        }
                    });


            for (File noteFile : noteList) {
                Scanner scan = new Scanner(noteFile);
                String content = "";
                while (scan.hasNextLine()) {
                    content = scan.nextLine() + "\n";
                }

                File noteFolderFile = noteFile.getParentFile();
                for (NoteFolder noteFolder : loadData.getData()) {
                    if (noteFolderFile.getName().equals(noteFolder.getName())) {
                        noteFolder.getFolder().add(new Note(noteFile.getName(), noteFolder.getFolder().size(), content));
                        addFolderListView.getItems().add(noteFolder.getName());
                    }
                }
            }
            loadData.setData(loadData.getData());




        } catch (IOException e) {
        e.printStackTrace();
        } catch (NullPointerException e) {
        e.printStackTrace();
        } catch (Exception e) {
        e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

}