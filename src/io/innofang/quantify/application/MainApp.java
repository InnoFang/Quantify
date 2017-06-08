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
        String result = Quantify.quantify();
        controller.updateConsole(result);

        List<Data> datas = new ArrayList<>();
        datas.add(new Data(new ArrayList<>(Arrays.asList(297, 450, 846, 292, 415, 252, 492, 474, 814, 934, 109)), Arrays.asList(207, 430, 845, 296, 417, 257, 482, 494, 810, 434, 139)));
        datas.add(new Data(new ArrayList<>(Arrays.asList(973, 845, 141, 606, 944, 132, 678, 362, 562, 854, 398)), Arrays.asList(973, 845, 141, 606, 944, 132, 678, 362, 562, 854, 398)));
        datas.add(new Data(new ArrayList<>(Arrays.asList(319, 855, 686, 44, 177, 193, 115, 8, 661, 773)), Arrays.asList(319, 855, 686, 44, 177, 193, 115, 8, 661, 773)));
        datas.add(new Data(new ArrayList<>(Arrays.asList(179, 990, 351, 116, 873, 313, 470)), Arrays.asList(179, 990, 351, 116, 873, 313, 470)));
        datas.add(new Data(new ArrayList<>(Arrays.asList(696, 446, 15, 15, 932, 709, 85, 357, 560)), Arrays.asList(696, 446, 15, 15, 932, 709, 85, 357, 560)));
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
