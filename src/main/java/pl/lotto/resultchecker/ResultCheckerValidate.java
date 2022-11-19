package pl.lotto.resultchecker;

import java.util.Set;

public class ResultCheckerValidate {
    ResultCheckerDto validateNumbers(Set<Integer> wonNumbers, Set<Integer>couponNumbers){
        Set<Integer> resultNumbers = compareNumbers(wonNumbers, couponNumbers);
        if(resultNumbers.size() == wonNumbers.size()) {
            return new ResultCheckerDto(wonNumbers,true);
        }
        return new ResultCheckerDto(wonNumbers,false);
    }

    private Set<Integer> compareNumbers(Set<Integer> wonNumbers, Set<Integer> couponNumbers) {
        couponNumbers.addAll(wonNumbers);
        return couponNumbers;
    }
}
