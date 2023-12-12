package racingcar.controller;

import racingcar.service.Service;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class Controller {

    private final InputView inputView;
    private final InputValidator inputValidator;
    private final OutputView outputView;
    private final Service service;
    private int playCount;

    public Controller(InputView inputView, InputValidator inputValidator, OutputView outputView, Service service) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
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
        playCount = inputValidator.convertStringToInt(inputView.readPlayCount());
        outputView.printResultStartMessage();
        while (playCount > 0) {
            service.play();
            outputView.printResult(service.getResultDto());
            playCount--;
        }
    }
}
