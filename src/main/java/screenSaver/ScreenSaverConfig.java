package screenSaver;

import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.awt.*;
import java.util.Random;

/**
 * Created by Evegeny on 14/03/2017.
 */
@Configuration
@ComponentScan
@EnableScheduling
public class ScreenSaverConfig {

    private Random random = new Random();

    @Bean
    public ColorFrame colorFrame(){
        return new ColorFrame() {
            @Override
            protected Color getColorBean() {
                return randomColor();
            }
        };
    }

    @Bean
    @Scope(value = "prototype")
    public Color randomColor(){
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }
}











