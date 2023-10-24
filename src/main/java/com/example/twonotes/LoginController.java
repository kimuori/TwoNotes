package com.example.twonotes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;

public class LoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button loginButton;

    /**
     * Changes scenes to the main UI when the user clicks on the "Log in" button.
     * @param event
     * @throws IOException
     */
    public void loginButtonOnAction (ActionEvent event) throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false); //prevents window resizing
        stage.show();
    }

    /**
     * Changes scenes to the signup UI when the user wants to create an account.
     * @param event
     * @throws IOException
     */
    public void signupPageButtonOnAction (ActionEvent event) throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signup.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false); //prevents window resizing
        stage.show();
    }

    /**
     * Changes scenes back to log in UI in case the user wants to return back to the starting point.
     * @param event
     * @throws IOException
     */
    public void loginPageButtonOnAction (ActionEvent event) throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false); //prevents window resizing
        stage.show();
    }

}