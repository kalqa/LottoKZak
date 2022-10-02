package pl.loto.numbergenerator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pl.lotto.numbergenerator.NumberGeneratorFacade;
import pl.lotto.numbergenerator.WonNumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NumberGeneratorSpec {

    @Test
    @DisplayName("should_return_won_number_list")
    public void should_return_won_number_list(){
        //given
        WonNumberGenerator wonNumberGenerator = new WonNumberGenerator();
        NumberGeneratorFacade numberGeneratorFacade = new NumberGeneratorFacade(wonNumberGenerator);
        //when
        List<Integer> resultNumberList = numberGeneratorFacade.retrieveWonNumbers();
        //then
        Assert.assertEquals(6,resultNumberList.size());
    }

    @Test
    @DisplayName("should_return_right_won_number_list")
    public void should_return_right_won_number_list(){
        //given
        List<Integer> wonNumbersMock = Arrays.asList(1,2,3,4,5,6);
        WonNumberGenerator wonNumberGeneratorMock = mock(WonNumberGenerator.class);
        NumberGeneratorFacade numberGeneratorFacade = new NumberGeneratorFacade(wonNumberGeneratorMock);
        when(wonNumberGeneratorMock.generateWonNumbers()).thenReturn(wonNumbersMock);
        //when
        List<Integer> resultNumberList = numberGeneratorFacade.retrieveWonNumbers();
        //then
        Assert.assertEquals(wonNumbersMock.get(0),resultNumberList.get(0));
        Assert.assertEquals(wonNumbersMock.get(1),resultNumberList.get(1));
        Assert.assertEquals(wonNumbersMock.get(2),resultNumberList.get(2));
        Assert.assertEquals(wonNumbersMock.get(3),resultNumberList.get(3));
        Assert.assertEquals(wonNumbersMock.get(4),resultNumberList.get(4));
        Assert.assertEquals(wonNumbersMock.get(5),resultNumberList.get(5));
    }
}