package calculator.domain;

public class Operand {
    private final static String NOT_NUMBER_MESSAGE = "피연산자에 문자열이 입력되었습니다.";
    private final static String NOT_POSITIVE_MESSAGE = "피연산자에 입력된 숫자가 양수가 아닙니다.";

    private final int operand;

    public Operand(String element) {
        int value = parseToInt(element);
        if (value <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_MESSAGE);
        }
        this.operand =value;
    }

    public int getOperand() {
        return operand;
    }

    private int parseToInt(String element) {
        try {
            return Integer.parseInt(element);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }

}
