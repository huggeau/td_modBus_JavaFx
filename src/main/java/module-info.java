module fr.btsciel.td_modbus_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.btsciel.td_modbus_javafx to javafx.fxml;
    exports fr.btsciel.td_modbus_javafx;
}