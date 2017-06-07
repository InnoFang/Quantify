package io.innofang.quantify.application;

/**
 * Created by Inno Fang on 2017/6/6.
 */

import io.innofang.quantify.controller.OperationInterfaceController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;

    private static class SingletonHolder {
        private static MainApp mainApp = new MainApp();
    }

    public static MainApp getInstance() {
        return SingletonHolder.mainApp;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Quantify");

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

            OperationInterfaceController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
