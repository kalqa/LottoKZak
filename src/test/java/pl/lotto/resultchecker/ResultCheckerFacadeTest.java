package pl.lotto.resultchecker;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.lotto.numbergenerator.NumberGeneratorFacade;
import pl.lotto.numbergenerator.NumberGeneratorWonNumber;
import pl.lotto.numberreceiver.NumberReceiverFacade;
import pl.lotto.numberreceiver.NumberUserCoupon;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ResultCheckerFacadeTest {

    @Test
    @DisplayName("should coupon is won")
    public void should_coupon_is_won() {
        //Given
        NumberReceiverFacade numberReceiverFacadeMock = mock(NumberReceiverFacade.class);
        NumberGeneratorFacade numberGeneratorFacadeMock = mock(NumberGeneratorFacade.class);
        ResultChecker resultCheckerMock = mock(ResultChecker.class);
        LocalDateTime drawDate = LocalDateTime.now();
        UUID uuid = new UUID(1L, 2L);
        ResultCheckerFacade resultCheckerFacade = new ResultCheckerFacade(
                numberReceiverFacadeMock, numberGeneratorFacadeMock, resultCheckerMock);
        NumberUserCoupon numberUserCoupon = new NumberUserCoupon(uuid, Set.of(1, 2, 3, 4, 5, 6), drawDate);
        List<NumberUserCoupon> numberUserCoupons = List.of(numberUserCoupon);
        NumberGeneratorWonNumber numberGeneratorWonNumber = new NumberGeneratorWonNumber(
                drawDate, Set.of(1, 2, 3, 4, 5, 6));
        when(numberReceiverFacadeMock.retrieveUserNumbers(drawDate)).thenReturn(numberUserCoupons);
        when(numberGeneratorFacadeMock.retrieveWonNumbers(drawDate)).thenReturn(numberGeneratorWonNumber);
        when(resultCheckerMock.checkCoupon(numberUserCoupons, numberGeneratorWonNumber, uuid, drawDate))
                .thenReturn(new ResultCheckerDto(Set.of(1, 2, 3, 4, 5, 6), true));
        //When
        ResultCheckerDto resultCheckerDto = resultCheckerFacade.checkWinner(drawDate, uuid);
        //Then
        assertTrue(resultCheckerDto.getWonNumbers().containsAll(Set.of(1, 2, 3, 4, 5, 6)));
        assertTrue(resultCheckerDto.isWon());
    }

    @Test
    @DisplayName("should coupon is lost")
    public void should_coupon_is_lost() {
        //Given
        NumberReceiverFacade numberReceiverFacadeMock = mock(NumberReceiverFacade.class);
        NumberGeneratorFacade numberGeneratorFacadeMock = mock(NumberGeneratorFacade.class);
        ResultChecker resultCheckerMock = mock(ResultChecker.class);
        LocalDateTime drawDate = LocalDateTime.now();
        UUID uuid = new UUID(1L, 2L);
        ResultCheckerFacade resultCheckerFacade = new ResultCheckerFacade(
                numberReceiverFacadeMock, numberGeneratorFacadeMock, resultCheckerMock);
        NumberUserCoupon numberUserCoupon = new NumberUserCoupon(uuid, Set.of(1, 2, 3, 4, 5, 6), drawDate);
        List<NumberUserCoupon> numberUserCoupons = List.of(numberUserCoupon);
        NumberGeneratorWonNumber numberGeneratorWonNumber = new NumberGeneratorWonNumber(
                drawDate, Set.of(2, 3, 4, 5, 6, 7));
        when(numberReceiverFacadeMock.retrieveUserNumbers(drawDate)).thenReturn(numberUserCoupons);
        when(numberGeneratorFacadeMock.retrieveWonNumbers(drawDate)).thenReturn(numberGeneratorWonNumber);
        when(resultCheckerMock.checkCoupon(numberUserCoupons, numberGeneratorWonNumber, uuid, drawDate))
                .thenReturn(new ResultCheckerDto(Set.of(2, 3, 4, 5, 6, 7), false));
        //When
        ResultCheckerDto resultCheckerDto = resultCheckerFacade.checkWinner(drawDate, uuid);
        //Then
        assertFalse(resultCheckerDto.getWonNumbers().containsAll(Set.of(1, 2, 3, 4, 5, 6)));
        assertFalse(resultCheckerDto.isWon());
    }
}
