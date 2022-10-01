package pl.lotto.numberreceiver;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

class NumberValidator {

    private static final int USER_NUMBER = 6;
    private static final int MIN_NUMBER_VALUE = 1;
    private static final int MAX_NUMBER_VALUE = 49;
    private static final LocalTime TIME_OF_DRAW = LocalTime.of(20, 0, 0, 0);

    boolean areExactlySixNumbers(List<Integer> targetNumbersFromUser) {
        return targetNumbersFromUser.size() != USER_NUMBER;
    }

    boolean isInRange(List<Integer> sortedListNumber) {
        return sortedListNumber.get(0) < MIN_NUMBER_VALUE
                || sortedListNumber.get(sortedListNumber.size() - 1) > MAX_NUMBER_VALUE;
    }

    LocalDateTime getDateOfDraw(LocalDateTime couponDate) {
        int dayNumber = DayOfWeek.SATURDAY.getValue()-couponDate.getDayOfWeek().getValue();

        if (couponDate.getDayOfWeek().getValue() > DayOfWeek.SUNDAY.getValue() &&
                couponDate.toLocalTime().isAfter(TIME_OF_DRAW)) {
            dayNumber = DayOfWeek.SATURDAY.getValue()
                    +(DayOfWeek.SUNDAY.getValue()-couponDate.getDayOfWeek().getValue());
        }
        return LocalDateTime.of(couponDate.toLocalDate().plusDays(dayNumber),TIME_OF_DRAW);
    }

}
