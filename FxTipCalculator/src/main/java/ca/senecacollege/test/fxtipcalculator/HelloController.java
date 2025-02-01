package ca.senecacollege.test.fxtipcalculator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class HelloController {

    @FXML
    private TextField bill_Amount_TextField;

    @FXML
    private TextField tip_Amount_TextField;

    @FXML
    private Label tip_Percentage_Label;

    @FXML
    private Slider tip_Percentage_Slider;

    @FXML
    private TextField total_To_Be_Paid_TextField;

    //private double tipPercentage;
    private BigDecimal tipPercentage = new BigDecimal(0.15);
    private static final NumberFormat PERCENTAGE = NumberFormat.getPercentInstance();
    private static final NumberFormat CURRENCY = NumberFormat.getCurrencyInstance();
    public void initialize(){

        tip_Percentage_Slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                tipPercentage = BigDecimal.valueOf(newValue.intValue()/100.00);
                tip_Percentage_Label.setText(PERCENTAGE.format(tipPercentage));
            }
        });
    }
    @FXML
    void onCalculateTip(ActionEvent event) {
            try {
                BigDecimal amount = new BigDecimal(bill_Amount_TextField.getText());
                BigDecimal tip = amount.multiply(tipPercentage);
                BigDecimal total = amount.add(tip);

                tip_Amount_TextField.setText(CURRENCY.format(tip));
                total_To_Be_Paid_TextField.setText(CURRENCY.format(total));
            }catch (NumberFormatException nex){
                bill_Amount_TextField.setText("Enter an appropriate amount");
                bill_Amount_TextField.selectAll();
                bill_Amount_TextField.requestFocus();
            }
    }

}
