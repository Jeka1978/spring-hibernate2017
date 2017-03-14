package quoters.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 14/03/2017.
 */
@Component
@Aspect
public class QuotersAspect {

    @Before("execution(* quoters..*.say*(..))")
    public void beforeSayMethods(JoinPoint jp){
        String originalBeanClass = jp.getTarget().getClass().getName();
        System.out.println("originalBeanClass = " + originalBeanClass);
        String proxyClass = jp.getThis().getClass().getName();
        System.out.println("proxyClass = " + proxyClass);
        Object[] args = jp.getArgs();
        for (Object arg : args) {
            System.out.println("arg = " + arg);
        }
        System.out.print("This is quote: ");
    }









}
