package pl.lotto.resultannouncer;

import pl.lotto.numberreceiver.NumberReceiverResultDto;
import pl.lotto.resultchecker.ResultCheckerDto;
import pl.lotto.resultchecker.ResultCheckerFacade;

public class ResultAnnouncerFacade {

    ResultCheckerFacade resultCheckerFacade;

    public ResultAnnouncerDto checkWinner(NumberReceiverResultDto numberReceiverResultDto) {
        numberReceiverResultDto.setMessage(ResultAnnouncerMessage.LOST_MESSAGE.getMessage());
        ResultCheckerDto resultCheckerDto = resultCheckerFacade
                .checkWinner(numberReceiverResultDto.getDrawDate(), numberReceiverResultDto.getUuid());
        if (resultCheckerDto.isWon()) {
            numberReceiverResultDto.setMessage(ResultAnnouncerMessage.WIN_MESSAGE.getMessage());
        }
        return new ResultAnnouncerDto(numberReceiverResultDto, resultCheckerDto.getWonNumbersList());
    }

}
