package org.apache.commons.lang3.time;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;
import java.util.function.Supplier;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class time_StopWatch_get_Supplier_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetWithSupplier() {
        StopWatch stopWatch = new StopWatch();
        Supplier<Object> supplier = () -> {
            // Simulate some processing
            return new Object();
        };

        Object result = null;
        try {
            stopWatch.start(); // Start the stopwatch before calling the supplier
            result = stopWatch.get(supplier);
        } catch (Exception e) {
            // Handle the exception if thrown
            e.printStackTrace();
        } finally {
            stopWatch.stop(); // Ensure the stopwatch is stopped
        }

        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testGetWithException() {
        StopWatch stopWatch = new StopWatch();
        Supplier<Object> supplier = () -> {
            throw new RuntimeException("Supplier exception");
        };

        Object result = null;
        try {
            stopWatch.start(); // Start the stopwatch before calling the supplier
            result = stopWatch.get(supplier);
        } catch (Exception e) {
            // Handle the exception if thrown
            assertNotNull(e);
            System.out.println("Caught exception: " + e.getMessage());
        } finally {
            stopWatch.stop(); // Ensure the stopwatch is stopped
        }

        assertNull(result); // This line is now valid
    }

}