package mySpring;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

/**
 * Created by Evegeny on 01/03/2017.
 */
public class InjectByTypeAnnotationObjectConfigurer implements ObjectConfigurer {
    @Override
    @SneakyThrows
    public void configure(Object t) {
        Class<?> type = t.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                Object object = ObjectFactory.getInstance().createObject(field.getType());
                field.setAccessible(true);
                field.set(t, object);
            }
        }
    }
}





