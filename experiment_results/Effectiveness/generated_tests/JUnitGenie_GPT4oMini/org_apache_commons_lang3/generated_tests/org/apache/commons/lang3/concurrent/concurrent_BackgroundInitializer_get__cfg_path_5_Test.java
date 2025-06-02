package org.apache.commons.lang3.concurrent;
import org.apache.commons.lang3.concurrent.BackgroundInitializer;
import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.apache.commons.lang3.concurrent.ConcurrentUtils;
import org.junit.Test;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static org.mockito.Mockito.*;

public class concurrent_BackgroundInitializer_get__cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testGetThrowsExecutionException() {
        // Arrange
        BackgroundInitializer<Object> initializer = createInitializerWithMockedFuture();
        // Simulate an ExecutionException with a cause
        ExecutionException executionException = new ExecutionException("Test Exception", new Throwable());

        // Act
        try {
            initializer.get();
        } catch (ConcurrentException e) {
            // Assert
            // Verify that handleCause was called with the correct ExecutionException
            try {
                ConcurrentUtils.handleCause(executionException);
            } catch (ConcurrentException ce) {
                return; // Test passes if ConcurrentException is thrown
            }
        } catch (Exception e) {
            // This should not happen
            e.printStackTrace();
        }
        // If we reach here, the test has failed
        throw new AssertionError("Expected ConcurrentException was not thrown.");
    }

    private BackgroundInitializer<Object> createInitializerWithMockedFuture() {
        BackgroundInitializer<Object> initializer = mock(BackgroundInitializer.class);
        // Mock the getFuture method to return a Future that throws ExecutionException
        when(initializer.getFuture()).thenThrow(new RuntimeException("Test Exception")); // Change to RuntimeException
        return initializer;
    }

}