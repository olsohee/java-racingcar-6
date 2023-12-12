package racingcar.view;

import racingcar.dto.ResultDto;
import racingcar.message.OutputMessage;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    private static class OutputViewHolder {
        private static OutputView outputView = new OutputView();
    }

    public static OutputView getInstance() {
        return OutputViewHolder.outputView;
    }

    public void printResultStartMessage() {
        System.out.println(OutputMessage.PRINT_RESULT_START_MESSAGE.getMessage());
    }

    public void printResult(List<ResultDto> resultDtos) {
        resultDtos.stream()
                .forEach(dto -> System.out.println(
                       String.format(OutputMessage.CAR_RESULT.getMessage(),
                               dto.getCarName(),
                               OutputMessage.POSITION.getMessage().repeat(dto.getPosition()))
                ));
        System.out.println();
    }
}
