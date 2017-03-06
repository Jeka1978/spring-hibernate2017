package quoters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

/**
 * Created by Evegeny on 06/03/2017.
 */
public class ContextListener implements ApplicationListener<ContextClosedEvent>{
    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        String[] names = factory.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name = " + name);
            BeanDefinition beanDefinition = factory.getBeanDefinition(name);
        }
    }
}






