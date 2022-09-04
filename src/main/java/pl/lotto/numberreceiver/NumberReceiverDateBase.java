package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.*;

public class NumberReceiverDateBase {
    private final Map<LocalDateTime, List<NumberUserCoupon>> couponLocalDateTimeListMap;

    public NumberReceiverDateBase() {
        couponLocalDateTimeListMap = new HashMap<>();
    }

    public void addToCouponLocalDateTimeListMap(LocalDateTime localDateTime, NumberUserCoupon numberUserCoupon){
        List<NumberUserCoupon> numberUserCoupons = couponLocalDateTimeListMap.get(localDateTime);
        numberUserCoupons.add(numberUserCoupon);
        couponLocalDateTimeListMap.put(localDateTime,numberUserCoupons);
    }

    public List<NumberUserCoupon> getListNumberUserCoupons(LocalDateTime localDateTime) {
        return couponLocalDateTimeListMap.get(localDateTime);
    }
}
