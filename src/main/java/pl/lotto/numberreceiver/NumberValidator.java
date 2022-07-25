package pl.lotto.numberreceiver;

import java.util.List;
import java.util.Set;

class NumberValidator {

    private static final int USER_NUMBER = 6;
    private static final int MIN_NUMBER_VALUE = 1;
    private static final int MAX_NUMBER_VALUE = 49;


    boolean areExactlySixNumbers(Set<Integer> targetNumbersFromUser) {
        return targetNumbersFromUser.size() != USER_NUMBER;
    }

    boolean isInRange(List<Integer> sortedListNumber) {
        return sortedListNumber.get(0) < MIN_NUMBER_VALUE
                || sortedListNumber.get(sortedListNumber.size() - 1) > MAX_NUMBER_VALUE;
    }
}
