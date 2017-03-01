package mySpring;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.lang.reflect.*;
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
        Method[] methods = type.getMethods();
        invokeInitMethods(t, methods);

        if (type.isAnnotationPresent(Benchmark.class)) {
            return (T) Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("********BENCHMARK******");
                    System.out.println(method.getName()+" started");
                    long start = System.nanoTime();
                    Object retVal = method.invoke(t, args);
                    long end = System.nanoTime();
                    System.out.println(end-start+" nanos");
                    System.out.println(method.getName()+" finished");
                    return retVal;
                }
            });
        }


        return t;
    }

    private <T> void invokeInitMethods(T t, Method[] methods) throws IllegalAccessException, InvocationTargetException {
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
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
