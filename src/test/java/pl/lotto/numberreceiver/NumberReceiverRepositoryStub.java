package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.*;

class NumberReceiverRepositoryStub  implements NumberReceiverRepository{

    private final Map<LocalDateTime,List<NumberUserCoupon>> dataBaseCoupons;

    public NumberReceiverRepositoryStub() {
        dataBaseCoupons = new HashMap<>();
    }

    @Override
    public NumberUserCoupon saveCoupon(NumberUserCoupon numberUserCoupon) {
        LocalDateTime dateDraw = numberUserCoupon.getDrawDate();
        List<NumberUserCoupon> numberUserCoupons = new ArrayList<>();
        if(dataBaseCoupons.containsKey(dateDraw)) {
            numberUserCoupons = dataBaseCoupons.get(dateDraw);
        }
        numberUserCoupons.add(numberUserCoupon);
        dataBaseCoupons.put(dateDraw,numberUserCoupons);
        return numberUserCoupon;
    }

    @Override
    public List<NumberUserCoupon> getCouponsFromDate(LocalDateTime drawDate) {
        if(dataBaseCoupons.containsKey(drawDate)){
            return dataBaseCoupons.get(drawDate);
        }
        return new ArrayList<>();
    }
}
