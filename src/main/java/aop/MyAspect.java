package aop;

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

    @Before("@annotation(Transaction)")
    public void handleTransactionMethods(){
        System.out.println("********TRANS is OPENED*********");
    }

}
