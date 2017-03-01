package mySpring;

/**
 * Created by Evegeny on 01/03/2017.
 */
public class Main {
    public static void main(String[] args) {
        ObjectFactory factory = ObjectFactory.getInstance();
        Object object = factory.createObject(IRobot.class);
    }
}
