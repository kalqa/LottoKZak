package pl.lotto.numberreceiver;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class NumberReceiverFacade {

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        return new NumberReceiverResultDto(Optional.of(UUID.randomUUID()), "");
    }
}
