package mySpring;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by Evegeny on 01/03/2017.
 */
public class ObjectFactory {

    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private List<ObjectConfigurer> configurers = new ArrayList<>();

    private Reflections scanner = new Reflections("mySpring");

    @SneakyThrows
    public ObjectFactory() {
        Set<Class<? extends ObjectConfigurer>> set = scanner.getSubTypesOf(ObjectConfigurer.class);
        for (Class<? extends ObjectConfigurer> configurerClass : set) {
            if (!Modifier.isAbstract(configurerClass.getModifiers())) {
                configurers.add(configurerClass.newInstance());
            }
        }
    }

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        type = resolveImpl(type);
        T t = type.newInstance();
        configure(t);


        return t;
    }

    private <T> void configure(T t) {
        for (ObjectConfigurer configurer : configurers) {
            configurer.configure(t);
        }
    }

    private <T> Class<T> resolveImpl(Class<T> type) {
        if (type.isInterface()) {
            type = config.getImpl(type);
        }
        return type;
    }


}
