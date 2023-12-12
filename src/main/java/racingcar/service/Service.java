package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.dto.FinalWinnerDto;
import racingcar.dto.ResultDto;

import java.util.List;

public class Service {

    private RacingCars racingCars;

    public void generateRacingCars(List<String> carNames) {
        racingCars = new RacingCars(carNames);
    }

    public void play() {
        racingCars.move();
    }

    public List<ResultDto> getResultDto() {
        return racingCars.getRacingCars().stream()
                .map(car -> new ResultDto(car.getCarName(), car.getPosition()))
                .toList();
    }

    public FinalWinnerDto getFinalWinnerDto() {
        List<Car> winners = racingCars.findWinners();
        List<String> winnerNames = winners.stream()
                .map(car -> car.getCarName())
                .toList();
        return new FinalWinnerDto(winnerNames);
    }
}
