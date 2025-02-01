module ca.senecacollege.test.fxtipcalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.senecacollege.test.fxtipcalculator to javafx.fxml;
    exports ca.senecacollege.test.fxtipcalculator;
}