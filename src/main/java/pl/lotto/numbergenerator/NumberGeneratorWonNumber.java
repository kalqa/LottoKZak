package pl.lotto.numbergenerator;

import java.time.LocalDateTime;

import java.util.Set;

public class NumberGeneratorWonNumber {

    private final LocalDateTime drawDate;
    private final Set<Integer> wonNumbers;

    public NumberGeneratorWonNumber(LocalDateTime drawDate, Set<Integer> wonNumbers) {
        this.drawDate = drawDate;
        this.wonNumbers = wonNumbers;
    }

    LocalDateTime getDrawDate() {
        return drawDate;
    }

    public Set<Integer> getWonNumbers() {
        return wonNumbers;
    }
}
