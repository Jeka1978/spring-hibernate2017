package quoters;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 06/03/2017.
 */
public class Main {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(MyJavaConfig.class);
    }
}