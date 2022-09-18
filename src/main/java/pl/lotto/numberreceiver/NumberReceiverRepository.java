package pl.lotto.numberreceiver;
import java.time.LocalDateTime;
import java.util.*;

interface NumberReceiverRepository {

    void saveCoupon(LocalDateTime drawDate, NumberUserCoupon userCoupon);

    boolean checkCoupon(LocalDateTime drawDate, NumberUserCoupon userCoupon);

    List<NumberUserCoupon> getCouponsFromDate(LocalDateTime drawDate);

}
