package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

public class NumberReceiverFacadeSpec {

    @Test
    @DisplayName("should return unique Id for user when given numbers were correct")
    public void should_return_unique_id_when_numbers_were_correct() {
        //given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().buildModuleForTests();
        List<Integer> numbersFromUser = Arrays.asList(1, 2, 3, 4, 5, 6);
        UUID couponNumber = UUID.randomUUID();
        NumberUserCoupon numberUserCoupon = new NumberUserCoupon(couponNumber,numbersFromUser);
       // NumberReceiverRepository numberReceiverRepositoryMock = Mockito.mock(NumberReceiverRepository.class);
        //NumberReceiverService numberReceiverService = new NumberReceiverService();
        //Mockito.when(numberReceiverRepositoryMock.checkCoupon(LocalDateTime.now(),numberUserCoupon)).thenReturn(true);
        //when
       // NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        //then
       // Assertions.assertEquals("OK",result.message());
    }

    @Test
    @DisplayName("should return a message to the user after specifying the wrong number of numbers")
    public void should_return_message_when_wrong_number_of_numbers() {
        //given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().buildModuleForTests();
        List<Integer> numbersFromUser = Arrays.asList(1, 2, 3, 4, 5);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        //then
        Assertions.assertEquals("Too few or duplicate numbers",result.message());
    }

    @Test
    @DisplayName("should return a message to the user after specifying the duplicate number of numbers")
    public void should_return_message_when_duplicate_number_of_numbers() {
        //given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().buildModuleForTests();
        List<Integer> numbersFromUser = Arrays.asList(1, 2, 3, 4, 5, 2);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        //then
        Assertions.assertEquals("Too few or duplicate numbers",result.message());
    }

    @Test
    @DisplayName("should return a message to the user after specifying the number under min value")
    public void should_return_message_when_one_of_number_is_under_min_value() {
        //given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().buildModuleForTests();
        List<Integer> numbersFromUser = Arrays.asList(0, 2, 3, 4, 5, 6);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        //then
        Assertions.assertEquals("Number not in limits",result.message());
    }

    @Test
    @DisplayName("should return a message to the user after specifying the number above max value")
    public void should_return_message_when_one_of_number_is_above_max_value() {
        //given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration().buildModuleForTests();
        List<Integer> numbersFromUser = Arrays.asList(60, 2, 3, 4, 5, 6);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        //then
        Assertions.assertEquals("Number not in limits",result.message());
    }
}
