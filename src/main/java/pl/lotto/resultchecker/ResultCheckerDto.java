package pl.lotto.resultchecker;
import java.util.Set;


public class ResultCheckerDto {
    private final Set<Integer> wonNumbers;
    private final boolean isWon;

    public ResultCheckerDto(Set<Integer> wonNumbers, boolean isWon) {
        this.wonNumbers = wonNumbers;
        this.isWon = isWon;
    }

    public Set<Integer> getWonNumbers() {
        return wonNumbers;
    }

    public boolean isWon() {
        return isWon;
    }
}
