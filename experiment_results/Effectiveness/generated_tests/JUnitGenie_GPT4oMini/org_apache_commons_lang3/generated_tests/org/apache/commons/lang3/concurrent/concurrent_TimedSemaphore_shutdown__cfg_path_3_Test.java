package org.apache.commons.lang3.concurrent;
import org.apache.commons.lang3.concurrent.TimedSemaphore;
import org.junit.Test;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import static org.mockito.Mockito.*;

public class concurrent_TimedSemaphore_shutdown__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testShutdown() {
        // Arrange
        ScheduledExecutorService executorService = mock(ScheduledExecutorService.class);
        ScheduledFuture<?> task = mock(ScheduledFuture.class);
        
        // Create an instance of TimedSemaphore with ownExecutor set to true
        TimedSemaphore timedSemaphore = new TimedSemaphore(1, TimeUnit.SECONDS, 1) {
            @Override
            protected ScheduledExecutorService getExecutorService() {
                return executorService;
            }
        };
        
        // Set the private fields using reflection
        try {
            java.lang.reflect.Field ownExecutorField = TimedSemaphore.class.getDeclaredField("ownExecutor");
            ownExecutorField.setAccessible(true);
            ownExecutorField.set(timedSemaphore, true);
            
            java.lang.reflect.Field taskField = TimedSemaphore.class.getDeclaredField("task");
            taskField.setAccessible(true);
            taskField.set(timedSemaphore, task);
            
            java.lang.reflect.Field shutdownField = TimedSemaphore.class.getDeclaredField("shutdown");
            shutdownField.setAccessible(true);
            shutdownField.set(timedSemaphore, false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Act
        timedSemaphore.shutdown();

        // Assert
        verify(executorService).shutdownNow();
        verify(task).cancel(false);
    }

}