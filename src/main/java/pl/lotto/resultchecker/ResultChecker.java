package pl.lotto.resultchecker;

import pl.lotto.numbergenerator.NumberGeneratorWonNumber;
import pl.lotto.numberreceiver.NumberUserCoupon;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class ResultChecker {

    ResultCheckerDto checkCoupon(List<NumberUserCoupon> numberUserCouponList,
                                 NumberGeneratorWonNumber numberGeneratorWonNumber, UUID uuidCoupon,
                                 LocalDateTime drawDate) {
        List<Integer> wonNumbers = numberGeneratorWonNumber.getWonNumberList();
        NumberUserCoupon numberUserCoupon = getNumberUserCoupon(numberUserCouponList, uuidCoupon, drawDate);
        if (numberUserCoupon.getCouponNumbers().isEmpty() || wonNumbers.isEmpty()) {
            return new ResultCheckerDto(wonNumbers, false);
        }
        List<Integer> resultList = getListToCheck(wonNumbers,
                numberUserCoupon.getCouponNumbers());
        if(resultList.size() == wonNumbers.size()) {
            return new ResultCheckerDto(wonNumbers,false);
        }
        return new ResultCheckerDto(wonNumbers,true);
    }

    private NumberUserCoupon getNumberUserCoupon(List<NumberUserCoupon> numberUserCouponList, UUID uuidCoupon,
                                                 LocalDateTime drawDate) {
       return numberUserCouponList.stream()
                .filter(c -> c.getUuid().equals(uuidCoupon))
                .findFirst()
                .orElse(new NumberUserCoupon(uuidCoupon, new ArrayList<>(), drawDate));
    }

    private List<Integer> getListToCheck(List<Integer> wonNumbersList, List<Integer> userNumbersList) {
        wonNumbersList.addAll(userNumbersList);
        return wonNumbersList.stream().distinct().toList();
    }

}
