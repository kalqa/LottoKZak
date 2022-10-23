package pl.lotto.resultchecker;
import java.util.List;



public class ResultCheckerDto {
    private List<Integer> wonNumbersList;
    private boolean isWon;

    public ResultCheckerDto(List<Integer> wonNumbersList, boolean isWon) {
        this.wonNumbersList = wonNumbersList;
        this.isWon = isWon;
    }

    public List<Integer> getWonNumbersList() {
        return wonNumbersList;
    }

    public boolean isWon() {
        return isWon;
    }
}
