package calculator.view;

import java.util.Scanner;

public class InputView {
    public String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.contains("\\n")) {
            input = input.replace("\\n", "\n");
        }
        return input.trim();
    }
}
