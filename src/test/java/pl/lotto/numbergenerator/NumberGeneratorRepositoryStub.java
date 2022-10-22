package pl.lotto.numbergenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class NumberGeneratorRepositoryStub implements NumberGeneratorRepository {
    private final Map<LocalDateTime, List<Integer>> wonNumberMap;

    public NumberGeneratorRepositoryStub() {
        wonNumberMap = new HashMap<>();
    }

    @Override
    public NumberGeneratorWonNumber saveWonNumber(NumberGeneratorWonNumber numberGeneratorWonNumber) {
        wonNumberMap.put(numberGeneratorWonNumber.getDrawDate(),numberGeneratorWonNumber.getWonNumberList());
        return numberGeneratorWonNumber;
    }

    @Override
    public NumberGeneratorWonNumber findWonNumberByDate(LocalDateTime drawDate) {
        if(wonNumberMap.containsKey(drawDate)){
            List<Integer> wonNumberList = wonNumberMap.get(drawDate);
            return new NumberGeneratorWonNumber(drawDate,wonNumberList);
        }
        return new NumberGeneratorWonNumber(drawDate, new ArrayList<>());
    }
}
