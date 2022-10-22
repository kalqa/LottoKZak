package pl.lotto.numbergenerator;

import java.time.LocalDateTime;

public class NumberGeneratorFacade {

    private final NumberGeneratorRepository numberGeneratorRepository;

    public NumberGeneratorFacade(NumberGeneratorRepository numberGeneratorRepository) {
        this.numberGeneratorRepository = numberGeneratorRepository;
    }

    public NumberGeneratorWonNumber retrieveWonNumbers(LocalDateTime drawDate) {
        return numberGeneratorRepository.findWonNumberByDate(drawDate);
    }
}
