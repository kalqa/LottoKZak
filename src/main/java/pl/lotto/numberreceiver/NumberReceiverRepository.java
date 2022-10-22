package pl.lotto.numberreceiver;
import java.time.LocalDateTime;
import java.util.*;

public interface NumberReceiverRepository {

    NumberUserCoupon saveCoupon(NumberUserCoupon numberUserCoupon);

    List<NumberUserCoupon> findCouponsFromDate(LocalDateTime drawDate);

}
