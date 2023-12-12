package racingcar.domain;

import racingcar.message.ErrorMessage;

public class Car implements Comparable<Car> {

    private String carName;
    private int position;

    public Car(String carName) {
        validateLength(carName);
        this.carName = carName;
        this.position = 0;
    }

    private void validateLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH.getErrorMessage());
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }
}
