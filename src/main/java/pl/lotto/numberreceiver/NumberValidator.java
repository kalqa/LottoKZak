package pl.lotto.numberreceiver;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

class NumberValidator {

    private static final int USER_NUMBER = 6;
    private static final int MIN_NUMBER_VALUE = 1;
    private static final int MAX_NUMBER_VALUE = 49;
    private static final String ERROR_QUANTITY_NUMBER = "Wrong number of numbers";
    private static final String ERROR_LIMIT_VALUE_NUMBER = "Number not in limits";
    private static final String VALIDATE_OK = "OK";
    private static final String ERROR_SAVE_COUPON = "Error save coupon";
    private static final LocalTime TIME_OF_DRAW = LocalTime.of(20, 0, 0, 0);


    String inputNumberValidate(List<Integer> numbersFromUser) {
        List<Integer> distinctList = numbersFromUser.stream().distinct().toList();
        if(distinctList.size()!=USER_NUMBER) {
            return ERROR_QUANTITY_NUMBER;
        } else if (Collections.max(distinctList)>MAX_NUMBER_VALUE || Collections.min(distinctList)<MIN_NUMBER_VALUE){
            return ERROR_LIMIT_VALUE_NUMBER;
        }
        return VALIDATE_OK;
    }

    String validateSaveCoupon(NumberReceiverRepository numberReceiverRepository, UUID couponNumber) {
        if(numberReceiverRepository.checkCoupon(couponNumber)) {
            return VALIDATE_OK;
        }
        return ERROR_SAVE_COUPON;
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
