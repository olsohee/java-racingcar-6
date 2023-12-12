package racingcar.domain;

import racingcar.message.ErrorMessage;

public class Car {

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
}
