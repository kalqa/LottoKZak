package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class NumberReceiverFacade {

    private static final String OK_MESSAGE = "OK";
    private static final String ERROR_QUANTITY_NUMBER = "Too few or duplicate numbers";
    private static final String ERROR_LIMIT_VALUE_NUMBER = "Number not in limits";
    private static final String ERROR_SAVE_COUPON = "Error save coupon";

    private final NumberValidator numberValidator;
    private final NumberReceiverRepository numberReceiverRepository;

    public NumberReceiverFacade(NumberValidator numberValidator, NumberReceiverRepository numberReceiverRepository) {
        this.numberValidator = numberValidator;
        this.numberReceiverRepository = numberReceiverRepository;
    }

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        List<Integer> sortedUserNumber = numbersFromUser.stream().distinct().sorted().collect(Collectors.toList());
        UUID couponNumber = UUID.randomUUID();
        LocalDateTime couponDrawDate = numberValidator.getDateOfDraw(LocalDateTime.now());
        if (numberValidator.areExactlySixNumbers(sortedUserNumber)) {
            return new NumberReceiverResultDto(couponNumber, ERROR_QUANTITY_NUMBER);
        }
        if (numberValidator.isInRange(sortedUserNumber)) {
            return new NumberReceiverResultDto(couponNumber, ERROR_LIMIT_VALUE_NUMBER);
        }
        NumberUserCoupon numberUserCoupon = numberReceiverRepository
                .saveCoupon(new NumberUserCoupon(couponNumber,sortedUserNumber,couponDrawDate));
        if(numberUserCoupon!= null && numberReceiverRepository.checkCoupon(numberUserCoupon.getUuid())) {
            return new NumberReceiverResultDto(numberUserCoupon.getUuid(), OK_MESSAGE);
        }
            return new NumberReceiverResultDto(couponNumber,ERROR_SAVE_COUPON);
    }

    public List<NumberUserCoupon> retrieveUserNumbers(LocalDateTime drawDate) {
        return numberReceiverRepository.getCouponsFromDate(drawDate);
    }
}
