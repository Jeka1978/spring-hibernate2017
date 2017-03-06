package quoters;

/**
 * Created by Evegeny on 06/03/2017.
 */
public interface BenchmarkFlagMBean {
    void setEnabled(boolean enabled);

    boolean isEnabled();

    void shutdown(int code);
}
