package racingcar;

import racingcar.controller.Controller;
import racingcar.service.Service;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        Controller controller = new Controller(InputView.getInstance(), InputValidator.getInstance(),
                OutputView.getInstance(), new Service());
        controller.start();
    }
}
