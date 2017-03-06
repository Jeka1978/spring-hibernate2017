package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 06/03/2017.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("aop");
        MyService myService = context.getBean(MyService.class);
        System.out.println(myService.getClass());

        myService.b();
    }
}
