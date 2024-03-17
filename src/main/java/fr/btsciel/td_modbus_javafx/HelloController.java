package fr.btsciel.td_modbus_javafx;

import fr.btsciel.td_modbus_javafx.helper.clavier.In;
import fr.btsciel.td_modbus_javafx.helper.crc16.CRC16;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;


import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    public CategoryAxis xAxis;
    public javafx.scene.chart.NumberAxis yAxis;
    public LineChart<String, Number> lineCharts;

    XYChart.Series series;
    private CRC16 crc16;
    public static int stdPoly = 0xA001; // polynome arbitraire du crc16
    public static int intialValue = 0xffff;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        series = new XYChart.Series<>();
        series.setName("ModBus");
        lineCharts.getData().add(series);
        lineCharts.setAnimated(false);
        lineCharts.setCreateSymbols(false);
        lineCharts.setCursor(Cursor.DEFAULT);

        printResult();

    }
    private void printResult(){
        String saisie;
        String regex = "([0-9]|[a-zA-Z])([0-9]|[a-zA-Z])";

//        mettre un if avec la verification du regex
        System.out.print("veuillez écrire votre trame d'octets: ");
        saisie = In.readString();
        System.out.println("le CRC= " + crc16.calculCrc16(crc16.formatage(saisie), intialValue, stdPoly));
    }
}