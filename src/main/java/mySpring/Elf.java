package mySpring;

import lombok.Data;

import java.util.Random;

/**
 * Created by Evegeny on 01/03/2017.
 */
@Data
public class Elf {
    @InjectRandomInt(min = 10, max = 40)
    private int power;
    @InjectRandomInt(min = 100, max = 150)
    private int dexterity;


}
