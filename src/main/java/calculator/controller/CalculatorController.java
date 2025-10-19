package calculator.controller;

import calculator.view.InputView;

public class CalculatorController {
    public void run(){
        InputView inputView = new InputView();
        String inputValue = inputView.readInput();

        System.out.println(inputValue);
    }
}
