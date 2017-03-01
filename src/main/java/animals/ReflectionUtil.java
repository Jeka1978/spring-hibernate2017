package animals;

import mySpring.InjectRandomInt;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by Evegeny on 01/03/2017.
 */
public class ReflectionUtil {
    public static void printApi(Object o) throws InvocationTargetException, IllegalAccessException {
        Class<?> type = o.getClass();
//        type.getDeclaredFields()

//
        Method[] methods = type.getMethods();
        for (Method method : methods) {
//            InjectRandomInt annotation = method.getAnnotation(InjectRandomInt.class);
//            annotation.max()
//            int modifiers = method.getModifiers();
//            if(Modifier.isAbstract(modifiers))
//            System.out.println(modifiers);
//            method.setAccessible(true);

            System.out.println(method.getName());
            if (method.getName().startsWith("init")) {
                method.invoke(o);
            }
        }
    }
}






