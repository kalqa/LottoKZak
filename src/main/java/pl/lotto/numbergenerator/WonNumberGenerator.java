package pl.lotto.numbergenerator;

import pl.lotto.numberreceiver.NumberReceiverDrawDate;

import java.time.LocalDateTime;
import java.util.*;

class WonNumberGenerator {

    private static final int NUMBER_OF_RANDOM_NUMBERS = 6;
    private static final int MIN_NUMBER_VALUE = 1;
    private static final int MAX_NUMBER_VALUE = 49;

    private final NumberGeneratorRepository numberGeneratorRepository;
    private final NumberReceiverDrawDate numberReceiverDrawDate;

    WonNumberGenerator(NumberGeneratorRepository numberGeneratorRepository, NumberReceiverDrawDate numberReceiverDrawDate) {
        this.numberGeneratorRepository = numberGeneratorRepository;
        this.numberReceiverDrawDate = numberReceiverDrawDate;
    }

    NumberGeneratorWonNumber saveWonNumbers() {
        Set<Integer> wonNumbers = generateWonNumbers();
        LocalDateTime drawDate = numberReceiverDrawDate.getDateOfDraw(LocalDateTime.now());
        return numberGeneratorRepository.saveWonNumber(new NumberGeneratorWonNumber(drawDate,wonNumbers));
    }

    private Set<Integer> generateWonNumbers() {
        Random generator = new Random();
        Set<Integer> wonNumbers = new HashSet<>();
        int number;
        do {
            number = generator.nextInt(MAX_NUMBER_VALUE) + MIN_NUMBER_VALUE;
                wonNumbers.add(number);
        } while (wonNumbers.size() < NUMBER_OF_RANDOM_NUMBERS);
        return wonNumbers;
    }
}
