package io.innofang.quantify.controller;

import io.innofang.quantify.model.Data;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.*;

/**
 * Created by Inno Fang on 2017/6/8.
 */
public class QuantifyStatisticsController implements Initializable {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;

    private ObservableList<String> originData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @SuppressWarnings("unchecked")
    public void setQuantifyData(Data data) {

        List<String> x = new ArrayList<>();
        for (int i = 1; i <= data.getBeforeData().size(); i++) {
            x.add(i + "");
        }
        originData.addAll(x);
        xAxis.setCategories(originData);
        barChart.setBarGap(3);
        XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
        series1.setName("量化前");
        XYChart.Series<String, Integer> series2 = new XYChart.Series<>();
        series2.setName("量化后");
        XYChart.Series<String, Integer> series3 = new XYChart.Series<>();
        series3.setName("差  值");

        for (int i = 0; i < x.size(); i++) {
            series1.getData().add(new XYChart.Data<>(x.get(i), data.getBeforeData().get(i)));
            series2.getData().add(new XYChart.Data<>(x.get(i), data.getAfterData().get(i)));
            series3.getData().add(new XYChart.Data<>(x.get(i), data.getDifferenceData().get(i)));
        }

        barChart.getData().addAll(series1, series2, series3);
    }
}
