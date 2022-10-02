package pl.lotto.numbergenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WonNumberGenerator {

    private static final int NUMBER_OF_RANDOM_NUMBERS = 6;
    private static final int MIN_NUMBER_VALUE = 1;
    private static final int MAX_NUMBER_VALUE = 49;
    private final Random generator;

    public WonNumberGenerator() {
        generator = new Random();
    }

    public List<Integer> generateWonNumbers() {
        List<Integer> wonNumbers = new ArrayList<>();
        Integer number;
        do {
            number = generator.nextInt(MAX_NUMBER_VALUE) + MIN_NUMBER_VALUE;
            if(!wonNumbers.contains(number)){
                wonNumbers.add(number);
            }
        } while (wonNumbers.size() < NUMBER_OF_RANDOM_NUMBERS);
        return wonNumbers;
    }
}
