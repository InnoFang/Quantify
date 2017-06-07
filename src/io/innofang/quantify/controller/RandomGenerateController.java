package io.innofang.quantify.controller;

import io.innofang.quantify.widget.NumberField;
import javafx.event.ActionEvent;
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
    private NumberField caseNumberTextField;
    @FXML
    private Button generateRandomNumberButton;
    @FXML
    private TextArea inputTextArea;
    @FXML
    private CheckBox editableCheckBox;

    private int caseNumber = 1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        caseNumberTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                    try {
                        caseNumber = Integer.parseInt(newValue);
                        if (caseNumber < 1) {
                            caseNumber = 1;
                        }
                        if (caseNumber > 50) {
                            caseNumber = 50;
                        }
                        caseNumberTextField.setText(Integer.toString(caseNumber));
                    } catch (NumberFormatException e) {
                        //to do nothing
                    }
                }

        );
    }


    @FXML
    private void handleEditable() {
        if (editableCheckBox.isSelected()) {
            inputTextArea.setEditable(true);
        } else {
            inputTextArea.setEditable(false);
        }
    }

    @FXML
    private void handleGenerateRandomNumber(ActionEvent event) {
        int cas = Integer.valueOf(caseNumberTextField.getText());

        System.out.println();
    }
}
