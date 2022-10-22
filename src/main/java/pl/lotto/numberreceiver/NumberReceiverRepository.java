package pl.lotto.numberreceiver;
import java.time.LocalDateTime;
import java.util.*;

interface NumberReceiverRepository {

    NumberUserCoupon saveCoupon(NumberUserCoupon numberUserCoupon);

    List<NumberUserCoupon> getCouponsFromDate(LocalDateTime drawDate);

}
