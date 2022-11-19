package pl.lotto.numbergenerator;

import java.time.LocalDateTime;
import java.util.*;

class NumberGeneratorRepositoryStub implements NumberGeneratorRepository {
    private final Map<LocalDateTime, Set<Integer>> wonNumberMap;

    public NumberGeneratorRepositoryStub() {
        wonNumberMap = new HashMap<>();
    }

    @Override
    public NumberGeneratorWonNumber saveWonNumber(NumberGeneratorWonNumber numberGeneratorWonNumber) {
        wonNumberMap.put(numberGeneratorWonNumber.getDrawDate(),numberGeneratorWonNumber.getWonNumbers());
        return numberGeneratorWonNumber;
    }

    @Override
    public NumberGeneratorWonNumber findWonNumberByDate(LocalDateTime drawDate) {
        if(wonNumberMap.containsKey(drawDate)){
            Set<Integer> wonNumberList = wonNumberMap.get(drawDate);
            return new NumberGeneratorWonNumber(drawDate,wonNumberList);
        }
        return new NumberGeneratorWonNumber(drawDate, new HashSet<>());
    }
}
