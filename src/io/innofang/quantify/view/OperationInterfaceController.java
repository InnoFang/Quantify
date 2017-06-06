package io.innofang.quantify.view;

import io.innofang.quantify.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Label;


/**
 * Created by Inno Fang on 2017/6/6.
 */
public class OperationInterfaceController {

    private MainApp mainApp;

    @FXML
    private Label consoleLabel;

    public OperationInterfaceController() {
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void initialize() {

        showConsoleInfo();

    }

    private void showConsoleInfo() {
        consoleLabel.setText("initial console");
    }

}
