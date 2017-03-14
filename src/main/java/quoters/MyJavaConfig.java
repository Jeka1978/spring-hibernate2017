package quoters;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by Evegeny on 14/03/2017.
 */
@Configuration
@PropertySource("classpath:quotes.properties")
@ComponentScan(basePackages = "quoters")
@EnableAspectJAutoProxy
public class MyJavaConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer configurer(){
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setIgnoreResourceNotFound(true);
        return configurer;
    }
}
