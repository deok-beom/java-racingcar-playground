package racing;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @Test
    void 자동차_이름_입력() {
        // given
        String input = "pobi,crong,loopy";

        // when
        Cars cars = new Cars("pobi,crong,loopy");

        // then
        StringBuilder actual = new StringBuilder(cars.get(0).getName());
        for (int i = 1; i < cars.size(); i++) {
            actual.append(",").append(cars.get(i).getName());
        }

        assertThat(actual.toString()).isEqualTo(input);
    }

    @RepeatedTest(100)
    void 주사위_굴림() {
        // given
        Cars cars = new Cars("");
        Stage stage = new Stage(cars);

        // when, then
        int num = stage.rollDice();
        assertThat(num).isGreaterThanOrEqualTo(0);
        assertThat(num).isLessThanOrEqualTo(9);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void 자동차_전진_시도(int num) {
        // given
        Car car = new Car("pororo");

        // when
        car.move(num);

        // then
        if (num >= 4) {
            assertThat(car.getLocation()).isEqualTo(1);
        } else {
            assertThat(car.getLocation()).isEqualTo(0);
        }
    }

    @Test
    void 우승자_구하기() {
        // given
        String input = "pororo,pobi,crong,loopy";
        Cars cars = new Cars(input);
        Stage stage = new Stage(cars);

        for (int i = 0; i < 3; i++) {
            cars.get(0).move(4);
        }

        for (int i = 0; i < 8; i++) {
            cars.get(1).move(4);
        }

        for (int i = 0; i < 4; i++) {
            cars.get(2).move(4);
        }

        for (int i = 0; i < 8; i++) {
            cars.get(3).move(4);
        }

        // when
        String winners = stage.getWinners();

        // then
        assertThat(winners).isEqualTo("pobi, loopy");
    }
}
