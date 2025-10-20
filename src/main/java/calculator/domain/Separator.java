package calculator.domain;

public class Separator {
    private static final String CUSTOM_LENGTH_MESSAGE = "커스텀 구분자는 5자 이하여야 합니다.";
    private static final String CUSTOM_COUNT_MESSAGE = "커스텀 구분자는 1개만 지정할 수 있습니다.";
    private static final String NOT_NUMBER_MESSAGE = "커스텀 구분자는 숫자가 될 수 없습니다.";
    private static final String INVALID_CUSTOM_MESSAGE = "커스텀 구분자는 기본 구분자 외의 문자여야 합니다.";

    private static final String defaultSeparator = "[,:]";
    private String separatorRegex = defaultSeparator;

    public Separator(String inputValue) {
        applyCustomSeparator(inputValue);
    }

    private void applyCustomSeparator(String inputValue) {
        if (!hasCustomSeparator(inputValue)) {
            return;
        }
        int start = 2;
        int end = inputValue.indexOf("\n");
        String custom = inputValue.substring(start, end);

        validate(custom);

        this.separatorRegex = defaultSeparator.substring(0,3)
                + custom
                + defaultSeparator.charAt(defaultSeparator.length() - 1);
    }
    public String[] split(String inputValue) {
        if (hasCustomSeparator(inputValue)) {
            int splitIndex = inputValue.indexOf("\n");
            inputValue = inputValue.substring(splitIndex + 1);
        }
        return inputValue.split(separatorRegex);
    }

    private Boolean hasCustomSeparator(String inputValue) {
        return inputValue.startsWith("//") && inputValue.indexOf("\n") >= 2;
    }

    private void validate(String custom) {
        if (custom.length() > 5) {
            throw new IllegalArgumentException(CUSTOM_LENGTH_MESSAGE);
        }
        if (custom.length() > 1) {
            throw new IllegalArgumentException(CUSTOM_COUNT_MESSAGE);
        }
        if (custom.matches("\\d+")) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
        if (custom.contains(",") || custom.contains(":")) {
            throw new IllegalArgumentException(INVALID_CUSTOM_MESSAGE);
        }
    }
}
