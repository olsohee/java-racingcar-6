package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String READ_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String READ_PLAY_COUNT = "시도할 회수는 몇회인가요?";

    private InputView() {
    }

    private static class InputViewHolder {
        private static InputView inputView = new InputView();
    }

    public static InputView getInstance() {
        return InputViewHolder.inputView;
    }

    public String readCarName() {
        System.out.println(READ_CAR_NAME);
        return Console.readLine();
    }

    public String readPlayCount() {
        System.out.println(READ_PLAY_COUNT);
        return Console.readLine();
    }
}
