package racingcar.domain;

import racingcar.message.ErrorMessage;

public class CarName {

    private final String carName;

    public CarName(String carName) {
        validateLength(carName);
        this.carName = carName;
    }

    private void validateLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH.getErrorMessage());
        }
    }

    public String getCarName() {
        return carName;
    }
}
