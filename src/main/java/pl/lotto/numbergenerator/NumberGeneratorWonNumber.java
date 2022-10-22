package pl.lotto.numbergenerator;

import java.time.LocalDateTime;
import java.util.List;

class NumberGeneratorWonNumber {

    private final LocalDateTime drawDate;
    private final List<Integer> wonNumberList;

    NumberGeneratorWonNumber(LocalDateTime drawDate, List<Integer> wonNumberList) {
        this.drawDate = drawDate;
        this.wonNumberList = wonNumberList;
    }

    LocalDateTime getDrawDate() {
        return drawDate;
    }

    List<Integer> getWonNumberList() {
        return wonNumberList;
    }
}
