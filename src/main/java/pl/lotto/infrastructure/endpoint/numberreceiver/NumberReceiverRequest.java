package pl.lotto.infrastructure.endpoint.numberreceiver;

import java.util.List;
import java.util.Set;

public class NumberReceiverRequest {

    Set<Integer> numbers;

    NumberReceiverRequest(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    Set<Integer> getNumbers() {
        return numbers;
    }
}
