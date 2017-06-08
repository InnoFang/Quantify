package io.innofang.quantify.controller;

import io.innofang.quantify.model.Data;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.*;

/**
 * Created by Inno Fang on 2017/6/8.
 */
public class QuantifyStatisticsController implements Initializable{

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;

    private ObservableList<String> originData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setQuantifyData(Data data) {

        List<String> x = new ArrayList<>();
        for (Integer integer : data.getBeforeData()) {
            x.add(Integer.toString(integer));
        }
        originData.addAll(x);
        xAxis.setCategories(originData);

        XYChart.Series<String, Integer> series = new XYChart.Series<>();

        for (int i = 0; i < x.size(); i++) {
            series.getData().add(new XYChart.Data<>(x.get(i), data.getAfterData().get(i)));
        }

        barChart.getData().add(series);
    }
}
