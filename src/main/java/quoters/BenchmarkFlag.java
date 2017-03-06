package quoters;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * Created by Evegeny on 06/03/2017.
 */
public class BenchmarkFlag implements BenchmarkFlagMBean {
    @Setter
    @Getter
    private boolean enabled;

    @SneakyThrows
    public BenchmarkFlag() {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        mBeanServer.registerMBean(this, new ObjectName("niceMBEANS", "name", "benchmark"));
    }

    @Override
    public void shutdown(int code){
        System.exit(code);
    }
}
