package io.innofang.quantify.controller;

import io.innofang.quantify.model.Data;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Inno Fang on 2017/6/8.
 */
public class MultiTabsDialogController implements Initializable {

    @FXML
    private TabPane tabPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setTabs(List<Data> data) {

        // add tabs
        for (int i = 1; i <= data.size(); i++) {
            Tab tab = new Tab("case " + i);
            tab.setClosable(false);
            tabPane.getTabs().add(tab);
        }

        // clear tabs
        tabPane.getSelectionModel().clearSelection();

        tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            @Override
            public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
                if (null == newValue.getContent()) {
                    try {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("../view/QuantifyStatistics.fxml"));
                        Parent root = loader.load();
                        newValue.setContent(root);

                        QuantifyStatisticsController controller = loader.getController();
                        int index = tabPane.getSelectionModel().getSelectedIndex();
                        controller.setQuantifyData(data.get(index));

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
