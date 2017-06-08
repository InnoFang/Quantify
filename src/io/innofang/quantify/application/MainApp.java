package io.innofang.quantify.application;

/**
 * Created by Inno Fang on 2017/6/6.
 */

import io.innofang.quantify.controller.MultiTabsDialogController;
import io.innofang.quantify.controller.OperationInterfaceController;
import io.innofang.quantify.model.Data;
import io.innofang.quantify.model.Quantify;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp extends Application {

    private Stage primaryStage;
    private OperationInterfaceController controller;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Quantify - Algorithm Design");

        showOperationInterface();
    }

    private void showOperationInterface() {
        try {
            // Load operation interface
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/OperationInterface.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);

            controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void execute() {
        List<Data> datas = Quantify.quantify();

        StringBuilder consoleInfo = new StringBuilder();
        for (int i = 0; i < datas.size(); i++) {
            consoleInfo.append(datas.get(i).getDescription());
        }

        controller.updateConsole(consoleInfo.toString());

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/MultiTabsDialog.fxml"));
            Parent root = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Quantify Statistics");
            dialogStage.initModality(Modality.NONE);
            dialogStage.initOwner(primaryStage);

            Scene scene = new Scene(root);
            dialogStage.setScene(scene);

            MultiTabsDialogController controller = loader.getController();
            controller.setTabs(datas);

            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
