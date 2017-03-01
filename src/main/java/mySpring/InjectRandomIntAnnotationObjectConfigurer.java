package mySpring;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by Evegeny on 01/03/2017.
 */
public class InjectRandomIntAnnotationObjectConfigurer implements ObjectConfigurer {
    @Override
    @SneakyThrows
    public void configure(Object t) {
        Class<?> type = t.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                Random random = new Random();
                int value = min + random.nextInt(max - min);
                field.setAccessible(true);
                field.set(t,value);
            }
        }
    }
}
