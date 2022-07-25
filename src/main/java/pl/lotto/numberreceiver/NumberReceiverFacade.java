package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class NumberReceiverFacade {

    private static final String OK_MESSAGE = "OK";
    private static final String ERROR_QUANTITY_NUMBER = "Too few or duplicate numbers";
    private static final String ERROR_LIMIT_VALUE_NUMBER = "Number not in limits";

    private final NumberValidator numberValidator;

    public NumberReceiverFacade(NumberValidator numberValidator) {
        this.numberValidator = numberValidator;
    }

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        Set<Integer> targetNumbersFromUser = new HashSet<>(numbersFromUser);
        if (numberValidator.areExactlySixNumbers(targetNumbersFromUser)) {
            return new NumberReceiverResultDto(Optional.of(UUID.randomUUID()), ERROR_QUANTITY_NUMBER);
        }
        List<Integer> sortedListNumber = new ArrayList<>(targetNumbersFromUser);
        Collections.sort(sortedListNumber);
        if (numberValidator.isInRange(sortedListNumber)) {
            return new NumberReceiverResultDto(Optional.of(UUID.randomUUID()), ERROR_LIMIT_VALUE_NUMBER);
        }
        return new NumberReceiverResultDto(Optional.of(UUID.randomUUID()), OK_MESSAGE);
    }

    public void retreiveUserNumbersForDate(LocalDateTime date){

    }
}
