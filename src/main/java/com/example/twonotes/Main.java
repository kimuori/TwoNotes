package com.example.twonotes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 400);
        stage.setTitle("TwoNotes");
        stage.setScene(scene);
        stage.setResizable(false); //prevents window resizing
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}