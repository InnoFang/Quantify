package io.innofang.quantify.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Inno Fang on 2017/6/7.
 */
public class RandomGenerateController implements Initializable {


    @FXML
    private TextField caseNumberTextField;
    @FXML
    private Button generateRandomNumberButton;
    @FXML
    private TextArea inputTextArea;
    @FXML
    private CheckBox editableCheckBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void handleEditable() {
        if (editableCheckBox.isSelected()) {
            inputTextArea.setEditable(true);
        } else {
            inputTextArea.setEditable(false);
        }
    }
}
