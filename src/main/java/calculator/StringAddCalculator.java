package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input) throws RuntimeException {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        String text = input;
        String delimiter = "[,:]";
        if (m.find()) {
            text = m.group(2);
            delimiter = m.group(1);
        }

        String[] tokens = text.split(delimiter);

        int result = 0;
        for (String token : tokens) {
            int number = parseInt(token);
            result += number;
        }

        return result;
    }

    private static int parseInt(String text) throws RuntimeException {
        int parsed;

        try {
            parsed = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 문자가 입력되었습니다.");
        }

        if (parsed < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }

        return parsed;
    }
}
