package racingcar;

import racingcar.controller.Controller;
import racingcar.service.Service;
import racingcar.validator.InputConvertor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        Controller controller = new Controller(InputView.getInstance(), InputConvertor.getInstance(),
                OutputView.getInstance(), new Service());
        controller.start();
    }
}
