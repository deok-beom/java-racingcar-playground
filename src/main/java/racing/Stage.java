package racing;

import util.Terminal;

public class Stage {

    private final Cars cars;
    private int round = 0;

    public Stage(Cars cars) {
        this.cars = cars;
    }

    public void proceedRound() {
        Terminal.outln("#[" + ++round + "]");

        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move(rollDice());
            Terminal.outln(cars.get(i).visualizeMoveState());
        }
        Terminal.outln("");
    }

    public int rollDice() {
        return (int) (Math.random() * 10);
    }

    public String getWinners() {
        Car[] sortedCars = cars.sort();

        StringBuilder sb = new StringBuilder(sortedCars[0].getName());
        int maxLocation = sortedCars[0].getLocation();
        for (int i = 1; i < sortedCars.length; i++) {
            if (sortedCars[i].getLocation() < maxLocation) {
                break;
            }

            sb.append(", ").append(sortedCars[i].getName());
        }

        return sb.toString();
    }
}
