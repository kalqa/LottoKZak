package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

class NumberReceiverRepositoryStub implements NumberReceiverRepository{

    private final UUID couponNumber;
    private final List<Integer> numbersFormUser;
    private final LocalDateTime drawDate;

    NumberReceiverRepositoryStub() {
        couponNumber = new UUID(111L,222L);
        numbersFormUser = Arrays.asList(1, 2, 3, 4, 5, 6);
        drawDate = LocalDateTime.of(
                2022,10,1,20,0,0,0);
    }

    @Override
    public NumberUserCoupon saveCoupon(NumberUserCoupon numberUserCoupon) {
        return new NumberUserCoupon(couponNumber,numbersFormUser,drawDate);
    }

    @Override
    public boolean checkCoupon(UUID uuid) {
        return true;
    }

    @Override
    public List<NumberUserCoupon> getCouponsFromDate(LocalDateTime drawDate) {
        return List.of(new NumberUserCoupon(couponNumber, numbersFormUser, drawDate));
    }
}
