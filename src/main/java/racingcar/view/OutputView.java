package racingcar.view;

import racingcar.dto.CarDto;

import java.util.List;

public final class OutputView {

    private static final String PLAY_RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자";
    private static final String COLON = " : ";
    private static final String POSITION_MARK = "-";
    private static final String DELIMITER = ", ";

    public void printPlayMessage() {
        System.out.println(PLAY_RESULT);
    }

    public void printResult(List<CarDto> carDtos) {
        carDtos.stream().forEach(car -> System.out.println(getCarStatus(car)));
        System.out.println();
    }

    private String getCarStatus(CarDto carDto) {
        return carDto.getName() + COLON + POSITION_MARK.repeat(carDto.getPosition());
    }

    public void printFinalWinners(List<String> winnerNames) {
        System.out.print(FINAL_WINNER + COLON);
        System.out.println(String.join(DELIMITER, winnerNames));
    }
}
