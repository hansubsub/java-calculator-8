package calculator.view;

import java.util.Scanner;

public class InputView {

    public String readInput(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.startsWith("//") && !input.contains("\n") && sc.hasNextLine()) {
            String second = sc.nextLine();
            input = input + "\n" + second;  // 실제 개행 삽입
        }
        return input.trim();
    }
}
