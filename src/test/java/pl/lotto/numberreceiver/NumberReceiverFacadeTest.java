package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class NumberReceiverFacadeTest {

    private final NumberReceiverRepositoryStub numberReceiverRepositoryStub = new NumberReceiverRepositoryStub();

    @Test
    @DisplayName("should return unique Id for user when given numbers were correct")
    public void should_return_unique_id_when_numbers_were_correct() {
        //given
        NumberReceiverFacade numberReceiverFacade =
                new NumberReceiverConfiguration(numberReceiverRepositoryStub).buildModuleForTests();
        Set<Integer> numbersFromUser = Set.of(1, 2, 3, 4, 5, 6);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        //then
        Assertions.assertEquals("OK",result.getMessage());
        Assertions.assertEquals(numbersFromUser.size(),result.getUserNumbers().size());
    }


    @Test
    @DisplayName("should return a message to the user after specifying the wrong number of numbers")
    public void should_return_message_when_wrong_number_of_numbers() {
        //given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration(numberReceiverRepositoryStub).buildModuleForTests();
        Set<Integer> numbersFromUser = Set.of(1, 2, 3, 4, 5);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        //then
        Assertions.assertEquals(NumberReceiverMessage.ERROR_QUANTITY_NUMBER.getMessage(),result.getMessage());
    }

    @Test
    @DisplayName("should return a message to the user after specifying the duplicate number of numbers")
    public void should_return_message_when_duplicate_number_of_numbers() {
        //given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration(numberReceiverRepositoryStub).buildModuleForTests();
        Set<Integer> numbersFromUser = Set.of(1, 2, 3, 4, 5);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        //then
        Assertions.assertEquals(NumberReceiverMessage.ERROR_QUANTITY_NUMBER.getMessage(),result.getMessage());
    }

    @Test
    @DisplayName("should return a message to the user after specifying the number under min value")
    public void should_return_message_when_one_of_number_is_under_min_value() {
        //given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration(numberReceiverRepositoryStub).buildModuleForTests();
        Set<Integer> numbersFromUser = Set.of(0, 2, 3, 4, 5, 6);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        //then
        Assertions.assertEquals(NumberReceiverMessage.ERROR_LIMIT_VALUE_NUMBER.getMessage(),result.getMessage());
    }

    @Test
    @DisplayName("should return a message to the user after specifying the number above max value")
    public void should_return_message_when_one_of_number_is_above_max_value() {
        //given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverConfiguration(numberReceiverRepositoryStub).buildModuleForTests();
        Set<Integer> numbersFromUser = Set.of(60, 2, 3, 4, 5, 6);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        //then
        Assertions.assertEquals(NumberReceiverMessage.ERROR_LIMIT_VALUE_NUMBER.getMessage(),result.getMessage());
    }

    @Test
    @DisplayName("should return list users coupon when given draw date correct")
    public void should_return_list_users_coupon_when_given_draw_date_correct() {
        //given
        NumberReceiverFacade numberReceiverFacade =
                new NumberReceiverConfiguration(numberReceiverRepositoryStub).buildModuleForTests();
        Set<Integer> numbersFromUserExpected = Set.of(1, 2, 3, 4, 5, 6);
        UUID couponNumberExpected = new UUID(111L,222L);
        LocalDateTime drawDateExpected = LocalDateTime.of(
                2022,10,1,20,0,0,0);
        NumberUserCoupon numberUserCoupon = new NumberUserCoupon(
                couponNumberExpected,numbersFromUserExpected,drawDateExpected);
        numberReceiverRepositoryStub.saveCoupon(numberUserCoupon);
        //when
        List<NumberUserCoupon> result = numberReceiverFacade.retrieveUserNumbers(drawDateExpected);
        //then
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertTrue(result.contains(numberUserCoupon));
    }
}
