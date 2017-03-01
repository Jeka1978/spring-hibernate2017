package animals;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Evegeny on 01/03/2017.
 */
public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        StamService stamService = new StamService();
        ReflectionUtil.printApi(stamService);
    }
}
