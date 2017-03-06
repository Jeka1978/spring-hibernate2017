package aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 06/03/2017.
 */
@Component
public class MyServiceImpl implements MyService {
    @Autowired
    private MyService proxy;

    @Override
    @Transaction
    public void a() {
        System.out.println("aaaaaaaaaaaaa");
    }

    @Override

    public void b() {
        System.out.println("BBBBBBbbbbbbbbbb");
        proxy.a();
    }
}
