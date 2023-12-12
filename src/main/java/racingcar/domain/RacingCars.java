package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.message.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private List<Car> racingCars = new ArrayList<>();

    public RacingCars(List<String> carNames) {
        validateDuplicated(carNames);
        this.racingCars = carNames.stream()
                .map(carName -> new Car(carName))
                .toList();
    }

    private void validateDuplicated(List<String> carNames) {
        long nonDuplicatedCount = carNames.stream()
                .distinct()
                .count();
        if (nonDuplicatedCount != carNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_CAR_NAME.getErrorMessage());
        }
    }

    public void move() {
        racingCars.stream()
                .forEach(car -> car.move(Randoms.pickNumberInRange(0, 9)));
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public List<Car> findWinners() {
        Car maxPositionCar = findMaxPositionCar();
        return racingCars.stream()
                .filter(car -> car.compareTo(maxPositionCar) == 0)
                .toList();
    }

    private Car findMaxPositionCar() {
        return racingCars.stream()
                .max((car1, car2) -> car1.compareTo(car2))
                .get();
    }
}
