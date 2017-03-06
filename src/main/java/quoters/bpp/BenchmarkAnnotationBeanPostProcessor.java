package quoters.bpp;

import mySpring.Benchmark;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import quoters.BenchmarkFlag;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Evegeny on 06/03/2017.
 */
public class BenchmarkAnnotationBeanPostProcessor implements BeanPostProcessor {

    private BenchmarkFlag benchmarkFlag = new BenchmarkFlag();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        Method[] methods = beanClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Benchmark.class)) {
                /*if (beanClass.getInterfaces().length == 0) {
                    return Enhancer.create(beanClass, new org.springframework.cglib.proxy.InvocationHandler() {
                        @Override
                        public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                            return null;
                        }
                    })
                }*/
                return Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                        beanClass.getInterfaces(),
                        new InvocationHandler() {
                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                                if (benchmarkFlag.isEnabled()) {
                                    System.out.println("********BENCHMARK******");
                                    System.out.println(method.getName()+" started");
                                    long start = System.nanoTime();
                                    Object retVal = method.invoke(bean, args);
                                    long end = System.nanoTime();
                                    System.out.println(end-start+" nanos");
                                    System.out.println(method.getName()+" finished");
                                    return retVal;
                                } else {
                                    return method.invoke(bean, args);
                                }
                            }
                        });
            }
        }
        return bean;
    }
}
