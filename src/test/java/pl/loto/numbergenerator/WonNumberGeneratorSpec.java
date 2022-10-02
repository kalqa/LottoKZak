package pl.loto.numbergenerator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import pl.lotto.numbergenerator.WonNumberGenerator;
import java.util.List;

public class WonNumberGeneratorSpec {

    @Test
    @DisplayName("should_return_won_number_list_with_different_numbers")
    public void should_return_won_number_list_with_different_numbers() {
        //given
        int expectedSize = 6;
        WonNumberGenerator wonNumberGenerator = new WonNumberGenerator();
        //when
        List<Integer> resultWonNumbers = wonNumberGenerator.generateWonNumbers();
        List<Integer> distinctWonNumbers = resultWonNumbers.stream().distinct().toList();
        //then
        Assert.assertEquals(expectedSize,resultWonNumbers.size());
        Assert.assertEquals(expectedSize,distinctWonNumbers.size());
    }
}
