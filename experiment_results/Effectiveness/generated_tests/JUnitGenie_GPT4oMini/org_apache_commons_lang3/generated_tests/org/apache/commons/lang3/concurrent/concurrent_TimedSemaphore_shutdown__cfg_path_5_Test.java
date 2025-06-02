package org.apache.commons.lang3.concurrent;
import org.apache.commons.lang3.concurrent.TimedSemaphore;
import org.junit.Test;
import static org.junit.Assert.*;

public class concurrent_TimedSemaphore_shutdown__cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testShutdown() {
        // Create an instance of TimedSemaphore with arbitrary parameters
        TimedSemaphore semaphore = new TimedSemaphore(1, java.util.concurrent.TimeUnit.SECONDS, 1);
        
        // Call shutdown method
        semaphore.shutdown();
        
        // Verify that shutdown is true after calling shutdown()
        // Using reflection to access the private field 'shutdown'
        try {
            java.lang.reflect.Field field = TimedSemaphore.class.getDeclaredField("shutdown");
            field.setAccessible(true);
            boolean isShutdown = (boolean) field.get(semaphore);
            assertTrue(isShutdown);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Exception occurred while accessing the shutdown field: " + e.getMessage());
        }
    }

}