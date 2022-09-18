package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class NumberReceiverFacade {

    private static final String OK_MESSAGE = "OK";
    private static final String ERROR_MESSAGE = "ERROR";
    private static final String ERROR_QUANTITY_NUMBER = "Too few or duplicate numbers";
    private static final String ERROR_LIMIT_VALUE_NUMBER = "Number not in limits";

    private final NumberValidator numberValidator;
    private final NumberReceiverService numberReceiverService;

    public NumberReceiverFacade(NumberValidator numberValidator, NumberReceiverService numberReceiverService) {
        this.numberValidator = numberValidator;
        this.numberReceiverService = numberReceiverService;
    }

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        List<Integer> sortedUserNumber = numbersFromUser.stream().distinct().sorted().collect(Collectors.toList());
        UUID couponNumber = UUID.randomUUID();
        LocalDateTime couponDrawDate = numberValidator.getDateOfDraw();

        if (numberValidator.areExactlySixNumbers(sortedUserNumber)) {
            return new NumberReceiverResultDto(couponNumber, ERROR_QUANTITY_NUMBER);
        }
        if (numberValidator.isInRange(sortedUserNumber)) {
            return new NumberReceiverResultDto(couponNumber, ERROR_LIMIT_VALUE_NUMBER);
        }
        boolean checkCouponInDB = numberReceiverService.saveCoupon(
                couponDrawDate,new NumberUserCoupon(couponNumber,sortedUserNumber));
        if (checkCouponInDB) {
            return new NumberReceiverResultDto(couponNumber, OK_MESSAGE);
        } else {
            return new NumberReceiverResultDto(couponNumber, ERROR_MESSAGE);
        }
    }

    public void retrieveUserNumbers(LocalDateTime drawDate) {
        numberReceiverService.getCouponsFromDate(drawDate);
    }
}
