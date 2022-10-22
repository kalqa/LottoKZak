package pl.lotto.numberreceiver;

import java.util.Collections;
import java.util.List;


class NumberValidator {

    private static final int USER_NUMBER = 6;
    private static final int MIN_NUMBER_VALUE = 1;
    private static final int MAX_NUMBER_VALUE = 49;

    NumberReceiverMessage inputNumberValidate(List<Integer> numbersFromUser) {
        List<Integer> distinctList = numbersFromUser.stream().distinct().toList();
        if(distinctList.size()!=USER_NUMBER) {
            return NumberReceiverMessage.ERROR_QUANTITY_NUMBER;
        } else if (Collections.max(distinctList)>MAX_NUMBER_VALUE || Collections.min(distinctList)<MIN_NUMBER_VALUE){
            return NumberReceiverMessage.ERROR_LIMIT_VALUE_NUMBER;
        }
        return NumberReceiverMessage.VALIDATE_OK;
    }

}
