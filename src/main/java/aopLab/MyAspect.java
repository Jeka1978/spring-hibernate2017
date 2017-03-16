package aopLab;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.lang.ref.WeakReference;
import java.util.*;

/**
 * Created by Evegeny on 16/03/2017.
 */
@Aspect
@Component
@PropertySource("classpath:mail.properties")
public class MyAspect {

    @Value("${dbaMails}")
    private String[] mails;


    private Map<DBException, Void> map = new WeakHashMap<>();


    @Pointcut("execution(* aopLab.business..*(..))")
    public void allBusinessMethods(){}

    @AfterThrowing(pointcut = "allBusinessMethods()", throwing = "ex")
    public void handleDBException(DBException ex) {
        if (!map.containsKey(ex)) {
            map.put(ex, null);
            for (String mail : mails) {
                System.out.println("sending mail to " + mail + " body = " + ex.getMessage());
            }
        }
    }
}








