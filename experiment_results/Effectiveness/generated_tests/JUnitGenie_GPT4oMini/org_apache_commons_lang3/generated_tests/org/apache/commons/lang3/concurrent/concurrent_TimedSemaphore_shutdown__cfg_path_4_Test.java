package org.apache.commons.lang3.concurrent;
import org.apache.commons.lang3.concurrent.TimedSemaphore;
import org.junit.Test;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertTrue;

public class concurrent_TimedSemaphore_shutdown__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testShutdownWithOwnExecutor() {
        // Arrange
        ScheduledExecutorService executorService = mock(ScheduledExecutorService.class);
        TimedSemaphore timedSemaphore = new TimedSemaphore(1, TimeUnit.SECONDS, 1) {
            {
                // Mocking the private fields for testing
                try {
                    java.lang.reflect.Field ownExecutorField = TimedSemaphore.class.getDeclaredField("ownExecutor");
                    ownExecutorField.setAccessible(true);
                    ownExecutorField.set(this, true);

                    java.lang.reflect.Field shutdownField = TimedSemaphore.class.getDeclaredField("shutdown");
                    shutdownField.setAccessible(true);
                    shutdownField.set(this, false);

                    java.lang.reflect.Field taskField = TimedSemaphore.class.getDeclaredField("task");
                    taskField.setAccessible(true);
                    taskField.set(this, mock(ScheduledFuture.class));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected ScheduledExecutorService getExecutorService() {
                return executorService;
            }
        };

        // Act
        timedSemaphore.shutdown();

        // Assert
        verify(executorService).shutdownNow();
    }

    @Test(timeout = 4000)
    public void testShutdownWithoutOwnExecutor() {
        // Arrange
        TimedSemaphore timedSemaphore = new TimedSemaphore(1, TimeUnit.SECONDS, 1) {
            {
                // Mocking the private fields for testing
                try {
                    java.lang.reflect.Field ownExecutorField = TimedSemaphore.class.getDeclaredField("ownExecutor");
                    ownExecutorField.setAccessible(true);
                    ownExecutorField.set(this, false);

                    java.lang.reflect.Field shutdownField = TimedSemaphore.class.getDeclaredField("shutdown");
                    shutdownField.setAccessible(true);
                    shutdownField.set(this, false);

                    java.lang.reflect.Field taskField = TimedSemaphore.class.getDeclaredField("task");
                    taskField.setAccessible(true);
                    taskField.set(this, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        // Act
        timedSemaphore.shutdown();

        // Assert
        // No exception should be thrown and shutdown should be set to true
        try {
            java.lang.reflect.Field shutdownField = TimedSemaphore.class.getDeclaredField("shutdown");
            shutdownField.setAccessible(true);
            assertTrue((Boolean) shutdownField.get(timedSemaphore)); // This line is now correct
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}