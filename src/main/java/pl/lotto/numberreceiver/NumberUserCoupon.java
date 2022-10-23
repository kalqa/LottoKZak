package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class NumberUserCoupon {

    private final UUID uuid;
    private final List<Integer> couponNumbers;
    private final LocalDateTime drawDate;

    public NumberUserCoupon(UUID uuid, List<Integer> couponNumbers, LocalDateTime drawDate) {
        this.uuid = uuid;
        this.couponNumbers = couponNumbers;
        this.drawDate = drawDate;
    }

    public UUID getUuid() {
        return uuid;
    }

    public List<Integer> getCouponNumbers() {
        return couponNumbers;
    }

    public LocalDateTime getDrawDate() {
        return drawDate;
    }

}
