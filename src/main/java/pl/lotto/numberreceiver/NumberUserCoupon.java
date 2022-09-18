package pl.lotto.numberreceiver;

import java.util.List;
import java.util.UUID;

class NumberUserCoupon {

    private UUID uuid;
    private List<Integer> couponNumbers;

    public NumberUserCoupon(UUID uuid, List<Integer> couponNumbers) {
        this.uuid = uuid;
        this.couponNumbers = couponNumbers;
    }

}
