package racingcar.dto;

import java.util.ArrayList;
import java.util.List;

public class FinalWinnerDto {

    private final List<String> winnerNames = new ArrayList<>();

    public FinalWinnerDto(List<String> winnerNames) {
        winnerNames.stream()
                .forEach(winnerName -> this.winnerNames.add(winnerName));
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}
