package tdd;

/**
 * Created by Evegeny on 06/03/2017.
 */
public class MaamResolver2 {
    private static MaamResolver2 ourInstance = new MaamResolver2();

    public static MaamResolver2 getInstance() {
        return ourInstance;
    }

    private MaamResolver2() {
    }

    public double getMaam(){
        return 0.17;
    }
}
