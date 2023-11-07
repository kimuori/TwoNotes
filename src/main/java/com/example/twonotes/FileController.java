package com.example.twonotes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class FileController implements Initializable {

    FileChooser filechooser = new FileChooser();

    @FXML
    private TextArea fileConent;

    @FXML
    private TextField fileTitle;

    @FXML
    public void open_File(ActionEvent actionEvent) {
        File file = filechooser.showOpenDialog(new Stage());

        try  {
            Scanner scan = new Scanner(file);

            Scanner scanTitle = new Scanner(file.getName());

            while (scanTitle.hasNextLine()){
                fileTitle.appendText(scanTitle.nextLine());
            }

            while (scan.hasNextLine()){
                fileConent.appendText(scan.nextLine() + "\n");
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        filechooser.setInitialDirectory(new File("C:\\Users"));
    }
}
