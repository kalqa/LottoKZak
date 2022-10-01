package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

class NumberUserCoupon {

    private final UUID uuid;
    private final List<Integer> couponNumbers;
    private final LocalDateTime drawDate;

    NumberUserCoupon(UUID uuid, List<Integer> couponNumbers, LocalDateTime drawDate) {
        this.uuid = uuid;
        this.couponNumbers = couponNumbers;
        this.drawDate = drawDate;
    }

    UUID getUuid() {
        return uuid;
    }

    List<Integer> getCouponNumbers() {
        return couponNumbers;
    }

    LocalDateTime getDrawDate() {
        return drawDate;
    }
}
