package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCars;
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
}
