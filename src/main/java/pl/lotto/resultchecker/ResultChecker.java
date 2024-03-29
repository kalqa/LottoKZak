package pl.lotto.resultchecker;

import pl.lotto.numbergenerator.NumberGeneratorWonNumber;
import pl.lotto.numberreceiver.NumberUserCoupon;

import java.time.LocalDateTime;
import java.util.*;

class ResultChecker {

    private final ResultCheckerValidate resultCheckerValidate;

    public ResultChecker() {
        resultCheckerValidate = new ResultCheckerValidate();
    }

    ResultCheckerDto checkCoupon(List<NumberUserCoupon> numberUserCoupons,
                                 NumberGeneratorWonNumber numberGeneratorWonNumber, UUID uuidCoupon,
                                 LocalDateTime drawDate) {
        Set<Integer> wonNumbers = numberGeneratorWonNumber.getWonNumbers();
        NumberUserCoupon numberUserCoupon = findUserCoupon(numberUserCoupons, uuidCoupon, drawDate);
        return resultCheckerValidate.validateNumbers(wonNumbers,numberUserCoupon.getCouponNumbers());
    }

    private NumberUserCoupon findUserCoupon(List<NumberUserCoupon> numberUserCoupons, UUID uuidCoupon,
                                            LocalDateTime drawDate) {
       return numberUserCoupons.stream()
                .filter(c->c.getDrawDate().equals(drawDate))
                .filter(c -> c.getUuid().equals(uuidCoupon))
                .findFirst()
                .orElseThrow(UserCouponException::new);
    }
}
