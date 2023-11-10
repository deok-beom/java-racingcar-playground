package racing;

import util.Terminal;

import java.io.IOException;

public class Game {
    public static void main(String[] args) throws IOException {

        String input;
        do {
            input = Terminal.in("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        } while (isOverInputCarNameLengthFive(input));

        int round = Integer.parseInt(Terminal.in("시도할 회수는 몇회인가요?"));

        Cars cars = new Cars(input);
        Stage stage = new Stage(cars);
        Terminal.outln("");
        Terminal.outln( "실행 결과");
        for (int i = 0; i < round; i++) {
            stage.proceedRound();
        }

        String sb = stage.getWinners() + "가 최종 우승했습니다.";
        Terminal.outln(sb);
    }

    private static boolean isOverInputCarNameLengthFive(String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            if (carName.trim().length() > 5) {
                return true;
            }
        }

        return false;
    }
}
