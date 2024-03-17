package fr.btsciel.td_modbus_javafx;

import fr.btsciel.td_modbus_javafx.helper.crc16.clavier.In;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

import fr.btsciel.td_modbus_javafx.helper.crc16.CRC16;


public class HelloController implements Initializable {

    public CategoryAxis xAxis;
    public javafx.scene.chart.NumberAxis yAxis;
    public Button stopBttn;
    public LineChart lineCharts;

    private CRC16 crc16;
    public static int stdPoly = 0xA001; // polynome arbitraire du crc16
    public static int intialValue = 0xffff;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stopBttn.setOnAction(event -> stopBttn());


    }

    private void stopBttn() {

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