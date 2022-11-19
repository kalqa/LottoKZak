package pl.lotto.resultannouncer;

import pl.lotto.numberreceiver.NumberReceiverResultDto;
import java.util.Set;

public class ResultAnnouncerDto {

    private NumberReceiverResultDto numberReceiverResultDto;
    private Set<Integer> wonNumbers;

    public ResultAnnouncerDto(NumberReceiverResultDto numberReceiverResultDto, Set<Integer> wonNumbers) {
        this.numberReceiverResultDto = numberReceiverResultDto;
        this.wonNumbers = wonNumbers;
    }

}
