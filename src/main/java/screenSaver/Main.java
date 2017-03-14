package screenSaver;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 14/03/2017.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScreenSaverConfig.class);
       /* while (true) {
            context.getBean(ColorFrame.class).fly();
            Thread.sleep(80);
        }*/
    }
}
