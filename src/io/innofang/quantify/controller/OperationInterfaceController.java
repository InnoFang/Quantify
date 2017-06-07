package io.innofang.quantify.controller;

import io.innofang.quantify.application.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by Inno Fang on 2017/6/6.
 */
public class OperationInterfaceController implements Initializable {

    private MainApp mainApp;

    @FXML
    private TabPane tabPane;

    @FXML
    private Label consoleLabel;

    public OperationInterfaceController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void showConsoleInfo() {
        consoleLabel.setText("initial console");
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
