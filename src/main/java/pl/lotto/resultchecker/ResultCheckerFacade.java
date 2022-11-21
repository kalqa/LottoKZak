package pl.lotto.resultchecker;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import pl.lotto.numbergenerator.NumberGeneratorFacade;
import pl.lotto.numbergenerator.NumberGeneratorWonNumber;
import pl.lotto.numberreceiver.NumberReceiverFacade;
import pl.lotto.numberreceiver.NumberUserCoupon;

public class ResultCheckerFacade {

    private final NumberReceiverFacade numberReceiverFacade;
    private final NumberGeneratorFacade numberGeneratorFacade;
    private final ResultChecker resultChecker;

    public ResultCheckerFacade(NumberReceiverFacade numberReceiverFacade, NumberGeneratorFacade numberGeneratorFacade,
                               ResultChecker resultChecker) {
        this.numberReceiverFacade = numberReceiverFacade;
        this.numberGeneratorFacade = numberGeneratorFacade;
        this.resultChecker = resultChecker;
    }

    public ResultCheckerDto checkWinner(LocalDateTime drawDate, UUID uuidCoupon) {
        List<NumberUserCoupon> numberUserCoupons = numberReceiverFacade.retrieveUserNumbers(drawDate);
        NumberGeneratorWonNumber numberGeneratorWonNumber = numberGeneratorFacade.retrieveWonNumbers(drawDate);
        return resultChecker.checkCoupon(numberUserCoupons, numberGeneratorWonNumber, uuidCoupon, drawDate);
    }


}
