package io.innofang.quantify.controller;

import io.innofang.quantify.application.MainApp;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by Inno Fang on 2017/6/6.
 */
public class OperationInterfaceController implements Initializable {

    private MainApp mainApp;

    @FXML
    private TextArea consoleTextArea;
    @FXML
    private TabPane tabPane;

    @FXML
    private Tab inputFromFileTab;
    @FXML
    private InputFromFileController inputFromFileController;

    @FXML
    private Tab randomGenerateTab;
    @FXML
    private RandomGenerateController randomGenerateController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        inputFromFileController.setMainApp(mainApp);
        randomGenerateController.setMainApp(mainApp);
    }

    public void updateConsole(String info) {
        consoleTextArea.setText(info);
    }
}
