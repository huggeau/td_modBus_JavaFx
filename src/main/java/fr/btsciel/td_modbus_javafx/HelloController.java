package fr.btsciel.td_modbus_javafx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {

    public CategoryAxis xAxis;
    public javafx.scene.chart.NumberAxis yAxis;
    public Button stopBttn;
    public LineChart lineCharts;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stopBttn.setOnAction(event -> stopBttn());


    }

    private void stopBttn() {

    }
}