package pl.lotto.numberreceiver;
import java.time.LocalDateTime;
import java.util.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberReceiverRepository extends MongoRepository<NumberUserCoupon, UUID> {

//    NumberUserCoupon saveCoupon(NumberUserCoupon numberUserCoupon);

//    List<NumberUserCoupon> findCouponsFromDate(LocalDateTime drawDate);
    List<NumberUserCoupon> findAllByDrawDate(LocalDateTime drawDate);

}
