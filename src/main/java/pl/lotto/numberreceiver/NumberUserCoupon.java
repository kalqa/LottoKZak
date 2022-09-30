package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

class NumberUserCoupon {

    private UUID uuid;
    private List<Integer> couponNumbers;
    private LocalDateTime drawDate;

    public NumberUserCoupon(UUID uuid, List<Integer> couponNumbers, LocalDateTime drawDate) {
        this.uuid = uuid;
        this.couponNumbers = couponNumbers;
        this.drawDate = drawDate;
    }

    public UUID getUuid() {
        return uuid;
    }
}
