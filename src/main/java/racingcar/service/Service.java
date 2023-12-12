package racingcar.service;

import racingcar.domain.RacingCars;

import java.util.List;

public class Service {

    private RacingCars racingCars;

    public void generateRacingCars(List<String> carNames) {
        racingCars = new RacingCars(carNames);
    }
}
