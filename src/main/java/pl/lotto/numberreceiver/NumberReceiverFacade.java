package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class NumberReceiverFacade {

    private final NumberValidator numberValidator;
    private final NumberReceiverDrawDate numberReceiverDrawDate;
    private final NumberReceiverRepository numberReceiverRepository;

    public NumberReceiverFacade(NumberValidator numberValidator, NumberReceiverDrawDate numberReceiverDrawDate, NumberReceiverRepository numberReceiverRepository) {
        this.numberValidator = numberValidator;
        this.numberReceiverDrawDate = numberReceiverDrawDate;
        this.numberReceiverRepository = numberReceiverRepository;
    }

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        UUID couponNumber = UUID.randomUUID();
        NumberReceiverMessage message = numberValidator.inputNumberValidate(numbersFromUser);
        if(message == NumberReceiverMessage.VALIDATE_OK) {
            LocalDateTime couponDrawDate = numberReceiverDrawDate.getDateOfDraw(LocalDateTime.now());
            numberReceiverRepository.saveCoupon(new NumberUserCoupon(couponNumber, numbersFromUser, couponDrawDate));
        }
        return new NumberReceiverResultDto(couponNumber,message.getMessage());
    }

    public List<NumberUserCoupon> retrieveUserNumbers(LocalDateTime drawDate) {
        return numberReceiverRepository.getCouponsFromDate(drawDate);
    }
}
