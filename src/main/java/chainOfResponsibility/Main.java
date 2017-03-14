package chainOfResponsibility;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 14/03/2017.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("chainOfResponsibility");
        MainValidator mainValidator = context.getBean(MainValidator.class);
        mainValidator.printErrors(new Person("MOSHE",-17));
    }
}
