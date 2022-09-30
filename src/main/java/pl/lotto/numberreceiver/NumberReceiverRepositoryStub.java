package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

class NumberReceiverRepositoryStub implements NumberReceiverRepository{

    @Override
    public NumberUserCoupon saveCoupon(NumberUserCoupon numberUserCoupon) {
        List<Integer> numbersFromUser = Arrays.asList(1, 2, 3, 4, 5, 6);
        UUID couponNumber = new UUID(111L,222L);
        LocalDateTime drawDate = LocalDateTime.of(
                2022,10,1,20,0,0,0);
        return new NumberUserCoupon(couponNumber,numbersFromUser,drawDate);
    }

    @Override
    public boolean checkCoupon(UUID uuid) {
        return true;
    }

    @Override
    public List<NumberUserCoupon> getCouponsFromDate(NumberDrawDate numberDrawDate) {
        return new ArrayList<>();
    }
}
