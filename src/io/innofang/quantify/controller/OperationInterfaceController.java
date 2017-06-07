package io.innofang.quantify.controller;

import io.innofang.quantify.application.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by Inno Fang on 2017/6/6.
 */
public class OperationInterfaceController implements Initializable {

    private MainApp mainApp;

    @FXML
    private TextArea consoleTextArea;

    public OperationInterfaceController() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
