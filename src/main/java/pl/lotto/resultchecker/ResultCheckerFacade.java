package pl.lotto.resultchecker;

import pl.lotto.numbergenerator.NumberGeneratorFacade;
import pl.lotto.numbergenerator.NumberGeneratorWonNumber;
import pl.lotto.numberreceiver.NumberReceiverFacade;
import pl.lotto.numberreceiver.NumberUserCoupon;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ResultCheckerFacade {

    private final NumberReceiverFacade numberReceiverFacade;
    private final NumberGeneratorFacade numberGeneratorFacade;
    private final ResultChecker resultChecker;

    public ResultCheckerFacade(NumberReceiverFacade numberReceiverFacade, NumberGeneratorFacade numberGeneratorFacade) {
        this.numberReceiverFacade = numberReceiverFacade;
        this.numberGeneratorFacade = numberGeneratorFacade;
        resultChecker = new ResultChecker();
    }

    public ResultCheckerDto checkWinner(LocalDateTime drawDate, UUID uuidCoupon){
        List<NumberUserCoupon> numberUserCouponList =  numberReceiverFacade.retrieveUserNumbers(drawDate);
        NumberGeneratorWonNumber numberGeneratorWonNumber = numberGeneratorFacade.retrieveWonNumbers(drawDate);
        return resultChecker.checkCoupon(numberUserCouponList,numberGeneratorWonNumber,uuidCoupon,drawDate);
    }


}
