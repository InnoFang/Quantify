package io.innofang.quantify;/**
 * Created by Inno Fang on 2017/6/6.
 */

import io.innofang.quantify.view.OperationInterfaceController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sun.applet.Main;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;

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
            loader.setLocation(MainApp.class.getResource("view/OperationInterface.fxml"));
            AnchorPane operationInterface = loader.load();

            Scene scene = new Scene(operationInterface);
            primaryStage.setScene(scene);

            OperationInterfaceController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
