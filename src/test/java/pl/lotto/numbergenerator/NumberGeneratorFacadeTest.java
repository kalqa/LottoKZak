package pl.lotto.numbergenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.lotto.numberreceiver.NumberReceiverDrawDate;
import java.time.LocalDateTime;

public class NumberGeneratorFacadeTest {

    @Test
    @DisplayName("should return list of Won number")
    public void should_return_list_of_Won_number() {
        //given
        NumberGeneratorRepository numberGeneratorRepository = new NumberGeneratorRepositoryStub();
        WonNumberGenerator wonNumberGenerator = new WonNumberGenerator(
                numberGeneratorRepository, new NumberReceiverDrawDate());
        NumberGeneratorWonNumber numberGeneratorWonNumberExpected = wonNumberGenerator.saveWonNumbers();
        NumberGeneratorFacade numberGeneratorFacade = new NumberGeneratorConfiguration(
                numberGeneratorRepository).buildModuleForTests();
        //when
        NumberGeneratorWonNumber numberGeneratorWonNumberResult = numberGeneratorFacade.retrieveWonNumbers(
                numberGeneratorWonNumberExpected.getDrawDate());
        //then
        Assertions.assertEquals(numberGeneratorWonNumberExpected.getDrawDate(), numberGeneratorWonNumberResult.getDrawDate());
        Assertions.assertEquals(numberGeneratorWonNumberExpected.getWonNumberList().size(), numberGeneratorWonNumberResult.getWonNumberList().size());
    }

    @Test
    @DisplayName("should return empty list of Won number")
    public void should_return_empty_list_of_Won_number() {
        //given
        NumberGeneratorRepository numberGeneratorRepository = new NumberGeneratorRepositoryStub();
        NumberGeneratorFacade numberGeneratorFacade = new NumberGeneratorConfiguration(
                numberGeneratorRepository).buildModuleForTests();
        LocalDateTime drawDate = LocalDateTime.now();
        //when
        NumberGeneratorWonNumber numberGeneratorWonNumberResult = numberGeneratorFacade.retrieveWonNumbers(drawDate);
        //then
        Assertions.assertEquals(drawDate, numberGeneratorWonNumberResult.getDrawDate());
        Assertions.assertTrue(numberGeneratorWonNumberResult.getWonNumberList().isEmpty());
    }
}
