package pl.lotto.resultannouncer;

import pl.lotto.numberreceiver.NumberReceiverResultDto;
import java.util.List;

public class ResultAnnouncerDto {

    private NumberReceiverResultDto numberReceiverResultDto;
    private List<Integer> wonNumbersList;

    public ResultAnnouncerDto(NumberReceiverResultDto numberReceiverResultDto, List<Integer> wonNumbersList) {
        this.numberReceiverResultDto = numberReceiverResultDto;
        this.wonNumbersList = wonNumbersList;
    }

}
