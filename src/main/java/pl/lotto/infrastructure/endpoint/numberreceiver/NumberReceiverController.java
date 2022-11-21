package pl.lotto.infrastructure.endpoint.numberreceiver;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lotto.numberreceiver.NumberReceiverFacade;
import pl.lotto.numberreceiver.NumberReceiverResultDto;

@RestController
public class NumberReceiverController {

    NumberReceiverFacade numberReceiverFacade;

    NumberReceiverController(NumberReceiverFacade numberReceiverFacade) {
        this.numberReceiverFacade = numberReceiverFacade;
    }

    @RequestMapping("/inputNumbers")
    public ResponseEntity<NumberReceiverRequest> inputNumbers(@RequestBody NumberReceiverRequest receiverRequest) {
        Set<Integer> numbers = receiverRequest.getNumbers();
        NumberReceiverResultDto numberReceiverResultDto = numberReceiverFacade.inputNumbers(numbers);
//        return ResponseEntity.ok();
    }
}
