package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NumberReceiverFacadeSpec {

    @Test
    @DisplayName("should return unique Id for user when given numbers were correct")
    public void should_return_unique_id_when_numbers_were_correct() {
        //given
        NumberReceiverFacade numberReceiverFacade =
                new NumberReceiverConfiguration(new NumberReceiverRepositoryStub()).buildModuleForTests();
        List<Integer> numbersFromUser = Arrays.asList(1, 2, 3, 4, 5, 6);
        UUID couponNumberExpected = new UUID(111L,222L);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        //then
        Assertions.assertEquals("OK",result.message());
        Assertions.assertEquals(couponNumberExpected,result.uuid());
    }

    @Test
    @DisplayName("should return message when save coupon not exist")
    public void should_return_message_when_save_coupon_not_exist() {
        //given
        NumberReceiverRepositoryStub numberReceiverRepositoryStubMock = mock(NumberReceiverRepositoryStub.class);
        NumberReceiverFacade numberReceiverFacade =
                new NumberReceiverConfiguration(numberReceiverRepositoryStubMock).buildModuleForTests();
        List<Integer> numbersFromUser = Arrays.asList(1, 2, 3, 4, 5, 6);
        UUID couponNumber = new UUID(111L,222L);
        when(numberReceiverRepositoryStubMock.checkCoupon(couponNumber)).thenReturn(false);
        //when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        //then
        Assertions.assertEquals("Error save coupon",result.message());
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

    @Test
    @DisplayName("should return list users coupon when given draw date correct")
    public void should_return_list_users_coupon_when_given_draw_date_correct() {
        //given
        NumberReceiverFacade numberReceiverFacade =
                new NumberReceiverConfiguration(new NumberReceiverRepositoryStub()).buildModuleForTests();
        List<Integer> numbersFromUserExpected = Arrays.asList(1, 2, 3, 4, 5, 6);
        UUID couponNumberExpected = new UUID(111L,222L);
        LocalDateTime drawDateExpected = LocalDateTime.of(
                2022,10,1,20,0,0,0);
        //when
        List<NumberUserCoupon> result = numberReceiverFacade.retrieveUserNumbers(drawDateExpected);
        //then
        Assertions.assertEquals(1,result.size());
        Assertions.assertEquals(couponNumberExpected,result.get(0).getUuid());
        Assertions.assertEquals(numbersFromUserExpected.size(),result.get(0).getCouponNumbers().size());
        Assertions.assertEquals(drawDateExpected,result.get(0).getDrawDate());
    }
}
