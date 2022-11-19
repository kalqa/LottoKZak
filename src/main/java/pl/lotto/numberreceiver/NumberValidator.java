package pl.lotto.numberreceiver;

import java.util.Collections;
import java.util.Set;


class NumberValidator {

    private static final int USER_NUMBER = 6;
    private static final int MIN_NUMBER_VALUE = 1;
    private static final int MAX_NUMBER_VALUE = 49;

    NumberReceiverMessage inputNumberValidate(Set<Integer> numbersFromUser) {
        if(numbersFromUser.size()==USER_NUMBER) {
            if((Collections.max(numbersFromUser)>MAX_NUMBER_VALUE
                    || Collections.min(numbersFromUser)<MIN_NUMBER_VALUE)) {
                return NumberReceiverMessage.ERROR_LIMIT_VALUE_NUMBER;
            }
            return NumberReceiverMessage.VALIDATE_OK;
        }
        return NumberReceiverMessage.ERROR_QUANTITY_NUMBER;
    }

}
