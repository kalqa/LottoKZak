package pl.lotto.numbergenerator;

import java.time.LocalDateTime;

interface NumberGeneratorRepository {

    NumberGeneratorWonNumber saveWonNumber(NumberGeneratorWonNumber numberGeneratorWonNumber);

    NumberGeneratorWonNumber findWonNumberByDate(LocalDateTime drawDate);

}
