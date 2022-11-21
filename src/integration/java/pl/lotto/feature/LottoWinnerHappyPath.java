package pl.lotto.feature;


/*
when user input 6 correct numbers (1,2,3,4,5,6) (in range 1-99) to /inputNumbers
system returns unique random userLotteryId and returned draw 05-07-2022 to user
system generates random winning numbers (1,2,3,4,5,6) using “lotto” logic for specifc date
user wants to know and if won using GET /winners/{userLotteryId}
system returns won result to user

        */

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import pl.lotto.BaseIntegrationSpec;
import pl.lotto.infrastructure.endpoint.numberreceiver.NumberReceiverRequest;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LottoWinnerHappyPath extends BaseIntegrationSpec {

    @Test
    public void happy_path_user_won_lottery() throws Exception {
        // given
        // when
        // POST /inputNumbers z liczbami 1,2,3,4,5,6
        ResultActions perform = mockMvc.perform(MockMvcRequestBuilders.post("/inputNumbers")
                .content(asJsonString(new NumberReceiverRequest(List.of(1, 2, 3, 4, 5, 6))))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
        // then
        perform.andExpect(status().isOk());

        // given
        // when
        // GET /winners(uuid)
        // then

        // when
        // clock + 7 dni

        // given
        // when
        // GET /winners(uuid)
        // then

    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
