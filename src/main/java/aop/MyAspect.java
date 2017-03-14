package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 06/03/2017.
 */
@Component
@Aspect
@EnableAspectJAutoProxy
public class MyAspect {

    @Around("@annotation(Transaction)")
    public void handleTransactionMethods(ProceedingJoinPoint pjp)  {
        System.out.println("********TRANS is OPENED*********");
        try {
            pjp.proceed();
        } catch (Throwable throwable) {
            System.out.println("Rollback");
        }
        System.out.println("********TRANS is Closed*********");
    }

}
