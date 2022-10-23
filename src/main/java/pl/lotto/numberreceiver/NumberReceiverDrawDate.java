package pl.lotto.numberreceiver;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class NumberReceiverDrawDate {

    private static final LocalTime TIME_OF_DRAW = LocalTime.of(20, 0, 0, 0);

    public LocalDateTime getDateOfDraw(LocalDateTime couponDate) {
        int dayNumber = DayOfWeek.SATURDAY.getValue()-couponDate.getDayOfWeek().getValue();
        if (couponDate.getDayOfWeek().getValue() > DayOfWeek.SUNDAY.getValue() &&
                couponDate.toLocalTime().isAfter(TIME_OF_DRAW)) {
            dayNumber = DayOfWeek.SATURDAY.getValue()
                    +(DayOfWeek.SUNDAY.getValue()-couponDate.getDayOfWeek().getValue());
        }
        return LocalDateTime.of(couponDate.toLocalDate().plusDays(dayNumber),TIME_OF_DRAW);
    }
}
