package racingcar.message;

public enum OutputMessage {

    PRINT_RESULT_START_MESSAGE("실행 결과"),
    CAR_RESULT("%s : %s"),
    POSITION("-"),
    FINAL_WINNER("최종 우승자 : %s")
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
