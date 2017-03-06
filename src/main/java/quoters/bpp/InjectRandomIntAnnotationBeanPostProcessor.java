package quoters.bpp;

import lombok.SneakyThrows;
import mySpring.InjectRandomInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by Evegeny on 06/03/2017.
 */
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    @SneakyThrows
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> type = bean.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                Random random = new Random();
                int value = min + random.nextInt(max - min);
                field.setAccessible(true);
                field.set(bean,value);
            }
        }
        return bean;
    }

    @Override
    @SneakyThrows
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        return bean;
    }
}
