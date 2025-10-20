package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    public void run(){
        InputView inputView = new InputView();
        String inputValue = inputView.readInput();

        Calculator calculator = new Calculator(inputValue);
        int result = calculator.sum();

        OutputView outputView = new OutputView();
        outputView.printOutput(result);
    }
}
