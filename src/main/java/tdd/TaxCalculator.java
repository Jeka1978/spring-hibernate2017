package tdd;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Evegeny on 06/03/2017.
 */
public class TaxCalculator {
    @Setter
    @Autowired
    private MaamResolver maamResolver;

    public double afterMaam(double price) {
        double maam = maamResolver.getMaam();
        return maam*price+price;
    }
}
