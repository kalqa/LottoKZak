package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class NumberReceiverFacade {

    private static final String OK_MESSAGE = "OK";
    private static final String ERROR_QUANTITY_NUMBER = "Too few or duplicate numbers";
    private static final String ERROR_LIMIT_VALUE_NUMBER = "Number not in limits";

    private final NumberValidator numberValidator;
    private final NumberReceiverDateBase numberReceiverDateBase;

    public NumberReceiverFacade(NumberValidator numberValidator, NumberReceiverDateBase numberReceiverDateBase)
    {
        this.numberValidator = numberValidator;
        this.numberReceiverDateBase = numberReceiverDateBase;
    }

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        List<Integer> sortedListNumber = numbersFromUser.stream().distinct().sorted().collect(Collectors.toList());
        Optional<UUID> uuid = Optional.of(UUID.randomUUID());
        if (numberValidator.areExactlySixNumbers(sortedListNumber)) {
            return new NumberReceiverResultDto(uuid, ERROR_QUANTITY_NUMBER);
        }
        if (numberValidator.isInRange(sortedListNumber)) {
            return new NumberReceiverResultDto(uuid, ERROR_LIMIT_VALUE_NUMBER);
        }
        LocalDateTime localDateTime = LocalDateTime.now();
        int valueDay = localDateTime.getDayOfWeek().getValue();
        if(valueDay<6)
        {
            localDateTime = localDateTime.plusDays(6-valueDay);
        }
        else if(valueDay==6 && localDateTime.getHour()>20) {
            localDateTime = localDateTime.plusDays(7);
        }
        else if(valueDay>6) {
            localDateTime = localDateTime.plusDays(6).withHour(1);
        }
        numberReceiverDateBase.addToCouponLocalDateTimeListMap(localDateTime,new NumberUserCoupon(uuid,sortedListNumber));
        return new NumberReceiverResultDto(uuid, OK_MESSAGE);
    }

    public void retrieveUserNumbersForDate(LocalDateTime date){
        numberReceiverDateBase.getListNumberUserCoupons(date);
    }
}
