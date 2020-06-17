package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class Controller {

    @FXML
    private TextField output;
    @FXML
    private Button button;

    private String operator = "";
    private double initialNumber = 0;
    private double result = 0;

    public void numpadPressed(ActionEvent event){
        String value = ((Button)event.getSource()).getText();
        output.appendText(value);
    }

    public void operationPressed(ActionEvent event){
        initialNumber = Double.parseDouble(output.getText());
        output.clear();
        operator = ((Button)event.getSource()).getText();
    }

    public void calculate(){
        double number = Double.parseDouble(output.getText());
        switch (operator){
            case "+":
                result = initialNumber + number;
                break;
            case "-":
                result = initialNumber - number;
                break;
            case "x":
                result = initialNumber * number;
                break;
            case "/":
                if(number == 0){
                    output.clear();
                    output.appendText("ZeroDivisionError!");
                } else {
                    result = initialNumber / number;
                }
                break;
        }

        initialNumber = result;
        output.clear();
        output.appendText(String.valueOf(result));
    }

    private static final String style = "-fx-background-color: #3CCCCC";

    public void changeColor(){
        button.setStyle(style);
    }
}
