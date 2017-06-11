package io.innofang.quantify.controller;

import io.innofang.quantify.application.MainApp;
import io.innofang.quantify.util.FileUtil;
import io.innofang.quantify.widget.NumberField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sun.applet.Main;

import java.net.URL;
import java.util.Random;
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

    private Random random = new Random();
    private int caseNumber = 1;
    private MainApp mainApp;

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

    public void setMainApp(MainApp mainApp) {
        if (this.mainApp == null) {
            this.mainApp = mainApp;
        }
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

        StringBuilder sb = new StringBuilder();
        sb.append(cas).append("\n");
        for (int i = 0; i < cas; i++) {
            int count = generateRandom(101);
            sb.append(count).append(" ");

            int s = generateRandom(11);
            while (s > count) {
                s = generateRandom(11);
            }
            sb.append(s).append("\n");

            for (int j = 0; j < count; j++) {
                sb.append(generateRandom(1000)).append(" ");
            }
            sb.append("\n");
        }
        inputTextArea.setText(sb.toString());
    }

    private int generateRandom(int bound) {
        int tmp = random.nextInt(bound);
        if (tmp == 0) tmp++;
        return tmp;
    }

    @FXML
    private void handleExecute() {
        String content = inputTextArea.getText();
        if (!"".equals(content)) {
            FileUtil.writeFileContent(content);
                mainApp.execute();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("提示");
            alert.setContentText("内容为空，无法执行");
            alert.show();
        }
    }
}
