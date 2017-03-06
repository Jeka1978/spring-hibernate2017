package tdd;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * Created by Evegeny on 06/03/2017.
 */
public class TaxCalculatorTest {
    @Test
    public void afterMaam() throws Exception {
        TaxCalculator taxCalculator = new TaxCalculator();
        MaamResolver resolver = Mockito.mock(MaamResolver.class);
        Mockito.when(resolver.getMaam()).thenReturn(0.17);
        taxCalculator.setMaamResolver(resolver);

        double realAnswer = taxCalculator.afterMaam(100);

        Assert.assertEquals(117,realAnswer,0.0001);
    }

}


