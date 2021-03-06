package io.innofang.quantify.controller;

import io.innofang.quantify.application.MainApp;
import io.innofang.quantify.util.FileUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.*;
import javafx.stage.FileChooser;

/**
 * Created by Inno Fang on 2017/6/7.
 */
public class InputFromFileController implements Initializable {

    @FXML
    private TextField pathTextField;

    @FXML
    private Button findFileButton;

    @FXML
    private TextArea inputTextArea;

    @FXML
    private CheckBox editableCheckBox;

    private MainApp mainApp;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setMainApp(MainApp mainApp) {
        if (this.mainApp == null) {
            this.mainApp = mainApp;
        }
    }

    @FXML
    private void handleOpenFileChooser() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "Quantify files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

        if (null != file) {
            pathTextField.setText(file.getPath());
            String content = FileUtil.getFileContent(file);
            inputTextArea.setText(content);
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
    private void handleExecute() {
        String content = inputTextArea.getText();
        if ("".equals(content)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("提示");
            alert.setContentText("内容为空，无法执行");
            alert.show();
            return;
        }
        FileUtil.writeFileContent(content);
        mainApp.execute();
    }

}
