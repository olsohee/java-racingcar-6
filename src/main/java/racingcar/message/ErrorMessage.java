package racingcar.message;

public enum ErrorMessage {

    INVALID_CAR_NAME_LENGTH("자동차 이름은 5글자 이하만 가능합니다."),
    DUPLICATED_CAR_NAME("자동차 이름은 중복될 수 없습니다."),
    INVALID_PLAY_COUNT("시도 횟수는 숫자여야 합니다.")
    ;

    private static final String ERROR_HEADER = "[ERROR]";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return String.format("%s %s", ERROR_HEADER, errorMessage);
    }
}
