package org.apache.commons.lang3.time;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;
import java.util.function.Supplier;
import static org.junit.Assert.assertNotNull;

public class time_StopWatch_get_Supplier_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGet() {
        StopWatch stopWatch = new StopWatch();
        Supplier<Object> supplier = () -> new Object(); // Supplier that returns a new Object

        stopWatch.start(); // Changed from startResume() to start()
        try {
            Object result = stopWatch.get(supplier);
            assertNotNull(result); // Ensure that the result is not null
        } finally {
            stopWatch.stop(); // Changed from suspend() to stop()
        }
    }


}