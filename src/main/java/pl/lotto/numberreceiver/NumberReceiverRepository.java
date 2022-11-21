package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberReceiverRepository extends MongoRepository<NumberUserCoupon, UUID> {

    List<NumberUserCoupon> findAllByDrawDate(LocalDateTime drawDate);

}
