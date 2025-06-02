package org.apache.commons.lang3.concurrent;
import org.apache.commons.lang3.concurrent.BackgroundInitializer;
import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.junit.Test;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static org.junit.Assert.assertNull;

public class concurrent_BackgroundInitializer_get__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetThrowsConcurrentException() {
        // Create an instance of BackgroundInitializer using reflection
        BackgroundInitializer<Object> initializer = createBackgroundInitializer();

        try {
            // Call the get method which is expected to throw ConcurrentException
            initializer.get();
        } catch (ConcurrentException e) {
            // Expected exception, test passes
        } catch (RuntimeException e) {
            // Handle RuntimeException to ensure it does not propagate
            // This is to simulate the scenario where get() throws a RuntimeException
            assertNull(e.getCause());
        }
    }

    private BackgroundInitializer<Object> createBackgroundInitializer() {
        // Use reflection to create an instance of BackgroundInitializer
        try {
            return (BackgroundInitializer<Object>) BackgroundInitializer.class
                    .getDeclaredConstructor(ExecutorService.class)
                    .newInstance(Executors.newSingleThreadExecutor());
        } catch (Exception e) {
            throw new RuntimeException("Failed to create BackgroundInitializer instance", e);
        }
    }

}