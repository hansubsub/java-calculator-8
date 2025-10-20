package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    private final List<Operand> operands;

    public Calculator(String inputValue) {
        Separator separator = new Separator(inputValue);
        String[] splitInput = separator.split(inputValue);
        this.operands = Arrays.stream(splitInput)
                .map(num -> new Operand(num))
                .collect(Collectors.toList());
    }

    public int sum() {
        return operands.stream()
                .mapToInt(operand -> operand.getOperand())
                .sum();
    }
}