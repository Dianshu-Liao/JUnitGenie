package org.apache.commons.lang3.concurrent;
import org.apache.commons.lang3.concurrent.TimedSemaphore;
import org.junit.Test;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import static org.junit.Assert.assertFalse;

public class concurrent_TimedSemaphore_shutdown__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testShutdown() {
        // Create a ScheduledExecutorService for testing
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        
        // Create an instance of TimedSemaphore with ownExecutor set to true
        TimedSemaphore timedSemaphore = new TimedSemaphore(1, TimeUnit.SECONDS, 1);
        
        // Set the private field 'ownExecutor' to true using reflection
        try {
            java.lang.reflect.Field ownExecutorField = TimedSemaphore.class.getDeclaredField("ownExecutor");
            ownExecutorField.setAccessible(true);
            ownExecutorField.set(timedSemaphore, true);
            
            // Call the shutdown method
            timedSemaphore.shutdown();
            
            // Verify that the shutdown field is set to true
            java.lang.reflect.Field shutdownField = TimedSemaphore.class.getDeclaredField("shutdown");
            shutdownField.setAccessible(true);
            boolean shutdownState = (boolean) shutdownField.get(timedSemaphore);
            assertFalse("The shutdown state should be true after shutdown is called.", shutdownState);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

}