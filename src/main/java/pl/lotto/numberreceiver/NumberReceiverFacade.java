package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class NumberReceiverFacade {

    private static final String OK_MESSAGE = "OK";
    private final NumberValidator numberValidator;
    private final NumberReceiverRepository numberReceiverRepository;

    public NumberReceiverFacade(NumberValidator numberValidator, NumberReceiverRepository numberReceiverRepository) {
        this.numberValidator = numberValidator;
        this.numberReceiverRepository = numberReceiverRepository;
    }

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        UUID couponNumber = UUID.randomUUID();
        String message = numberValidator.inputNumberValidate(numbersFromUser);
        if(message.equals(OK_MESSAGE)) {
            LocalDateTime couponDrawDate = numberValidator.getDateOfDraw(LocalDateTime.now());
            numberReceiverRepository.saveCoupon(new NumberUserCoupon(couponNumber, numbersFromUser, couponDrawDate));
            message = numberValidator.validateSaveCoupon(numberReceiverRepository,couponNumber);
        }
        return new NumberReceiverResultDto(couponNumber,message);
    }

    public List<NumberUserCoupon> retrieveUserNumbers(LocalDateTime drawDate) {
        return numberReceiverRepository.getCouponsFromDate(drawDate);
    }
}
