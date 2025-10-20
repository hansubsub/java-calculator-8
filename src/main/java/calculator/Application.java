package calculator;

import calculator.controller.CalculatorController;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CalculatorController calculator = new CalculatorController();
        calculator.run();
        OutputView outputView = new OutputView();
        outputView.printOutput(123);
    }
}
