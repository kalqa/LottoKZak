package pl.lotto.resultannouncer;

import pl.lotto.numberreceiver.NumberReceiverResultDto;
import pl.lotto.resultchecker.ResultCheckerDto;
import pl.lotto.resultchecker.ResultCheckerFacade;

public class ResultAnnouncerFacade {

    private ResultCheckerFacade resultCheckerFacade;

    public ResultAnnouncerFacade(ResultCheckerFacade resultCheckerFacade) {
        this.resultCheckerFacade = resultCheckerFacade;
    }

    public ResultAnnouncerDto checkWinner(NumberReceiverResultDto numberReceiverResultDto) {
        numberReceiverResultDto.setMessage(ResultAnnouncerMessage.LOST_MESSAGE.getMessage());
        ResultCheckerDto resultCheckerDto = resultCheckerFacade
                .checkWinner(numberReceiverResultDto.getDrawDate(),numberReceiverResultDto.getUuid());
        if(resultCheckerDto.isWon()) {
            numberReceiverResultDto.setMessage(ResultAnnouncerMessage.WIN_MESSAGE.getMessage());
        }
        return new ResultAnnouncerDto(numberReceiverResultDto,resultCheckerDto.getWonNumbers());
    }

}
