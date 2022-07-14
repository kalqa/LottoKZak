package pl.lotto.numberreceiver;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NumberReceiverFacadeSpec {

    @Test
    @DisplayName("should return unique Id for user when given numbers were correct")
    public void should_return_unique_id_when_numbers_were_correct() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacade();
        List<Integer> numbersFromUser = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);

        // then
        assertThat(result.uuid()).isPresent();
    }
}
