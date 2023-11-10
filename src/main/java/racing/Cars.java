package racing;

import java.util.Arrays;

public class Cars {
    private final Car[] cars;

    public Cars(String input) {
        String[] carNames = input.split(",");
        int size = carNames.length;
        cars = new Car[size];

        for (int i = 0; i < size; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    public Car get(int index) {
        return cars[index];
    }

    public int size() {
        return cars.length;
    }

    public Car[] sort() {
        Car[] cars = Arrays.copyOf(this.cars, this.cars.length);
        sort(cars, 0, cars.length - 1);
        return cars;
    }

    private void sort(Car[] cars, int left, int right) {
        if (left >= right) {
            return;
        }

        int middle = (left + right) / 2;

        sort(cars, left, middle);
        sort(cars, middle + 1, right);

        merge(cars, left, middle, right);
    }

    private void merge(Car[] cars, int left, int middle, int right) {
        Car[] leftArray = Arrays.copyOfRange(cars, left, middle + 1);
        Car[] rightArray = Arrays.copyOfRange(cars, middle + 1, right + 1);

        int i = 0, j = 0;
        int cursor = left;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i].getLocation() >= rightArray[j].getLocation()) {
                cars[cursor] = leftArray[i];
                i++;
            } else {
                cars[cursor] = rightArray[j];
                j++;
            }
            cursor++;
        }

        while (i < leftArray.length) {
            cars[cursor] = leftArray[i];
            i++;
            cursor++;
        }

        while (j < rightArray.length) {
            cars[cursor] = rightArray[j];
            j++;
            cursor++;
        }
    }
}
