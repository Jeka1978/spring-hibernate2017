package mySpring;

/**
 * Created by Evegeny on 01/03/2017.
 */
public interface Config {
    <T> Class<T> getImpl(Class<T> type);
}
