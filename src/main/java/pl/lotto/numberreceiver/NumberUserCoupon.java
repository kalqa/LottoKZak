package pl.lotto.numberreceiver;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class NumberUserCoupon {
    private Optional<UUID> uuid;
    private List<Integer> couponNumbers;

    public NumberUserCoupon(Optional<UUID> uuid, List<Integer> couponNumbers) {
        this.uuid = uuid;
        this.couponNumbers = couponNumbers;
    }

}
