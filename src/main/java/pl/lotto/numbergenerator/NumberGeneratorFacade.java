package pl.lotto.numbergenerator;

import java.util.List;

public class NumberGeneratorFacade {
    private final WonNumberGenerator wonNumberGenerator;

    public NumberGeneratorFacade(WonNumberGenerator wonNumberGenerator) {
        this.wonNumberGenerator = wonNumberGenerator;
    }

    public List<Integer> retrieveWonNumbers() {
        return wonNumberGenerator.generateWonNumbers();
    }
}
