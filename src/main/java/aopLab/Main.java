package aopLab;

import aopLab.business.MyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 16/03/2017.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Conf.class);
        try {
            context.getBean(MyService.class).doWork();

        } catch (Exception e) {
            System.out.println("something went wrong we will try again later");
        }
    }
}
