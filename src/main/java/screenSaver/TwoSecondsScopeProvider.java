package screenSaver;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.concurrent.TimeUnit;

/**
 * Created by Evegeny on 14/03/2017.
 */
public class TwoSecondsScopeProvider implements Scope {
    private Cache<String, Object> cache;

    public TwoSecondsScopeProvider() {
        cache = CacheBuilder.newBuilder().expireAfterWrite(2000, TimeUnit.MILLISECONDS).build();
    }

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object bean = cache.getIfPresent(name);
        if (bean == null) {
            System.out.println(12312312);
            Object object = objectFactory.getObject();
            cache.put(name,object);
            return object;
        }
        return bean;
    }
















    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
