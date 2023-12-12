package racingcar.controller;

import racingcar.service.Service;
import racingcar.validator.InputConvertor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class Controller {

    private final InputView inputView;
    private final InputConvertor inputConvertor;
    private final OutputView outputView;
    private final Service service;
    private int playCount;

    public Controller(InputView inputView, InputConvertor inputConvertor, OutputView outputView, Service service) {
        this.inputView = inputView;
        this.inputConvertor = inputConvertor;
        this.outputView = outputView;
        this.service = service;
    }

    public void start() {
        generateRacingCars();
        play();
    }

    private void generateRacingCars() {
        List<String> carNames = Arrays.stream(inputView.readCarName().split(","))
                .map(name -> name.trim())
                .toList();
        service.generateRacingCars(carNames);
    }

    private void play() {
        playCount = inputConvertor.convertToInt(inputView.readPlayCount());
        outputView.printResultStartMessage();
        while (playCount > 0) {
            service.play();
            outputView.printResult(service.getResultDto());
            playCount--;
        }
        outputView.printFinalWinner(service.getFinalWinnerDto());
    }
}
