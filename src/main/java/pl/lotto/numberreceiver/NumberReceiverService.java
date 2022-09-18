package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;

class NumberReceiverService {

    private NumberReceiverRepository numberReceiverRepository;

    public NumberReceiverService() {
    }

    public NumberReceiverService(NumberReceiverRepository numberReceiverRepository) {
        this.numberReceiverRepository = numberReceiverRepository;
    }

    boolean saveCoupon(LocalDateTime drawDate, NumberUserCoupon userCoupon) {
        numberReceiverRepository.saveCoupon(drawDate, userCoupon);
        return numberReceiverRepository.checkCoupon(drawDate, userCoupon);
    }

    List<NumberUserCoupon> getCouponsFromDate(LocalDateTime drawDate) {
        return getCouponsFromDate(drawDate);
    }
}
