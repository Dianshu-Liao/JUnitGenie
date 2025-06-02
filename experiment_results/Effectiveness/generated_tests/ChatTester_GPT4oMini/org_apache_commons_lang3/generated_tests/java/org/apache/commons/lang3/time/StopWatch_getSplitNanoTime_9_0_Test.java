package org.apache.commons.lang3.time;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableRunnable;
import org.apache.commons.lang3.function.FailableSupplier;

public class StopWatch_getSplitNanoTime_9_0_Test {

    private StopWatch stopWatch;

    @BeforeEach
    public void setUp() {
        stopWatch = new StopWatch();
    }

    @Test
    public void testGetSplitNanoTime_ThrowsException_WhenNotSplit() {
        // Arrange: Ensure the stopwatch is in the UNSTARTED state
        // Act & Assert: Expect IllegalStateException when calling getSplitNanoTime
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            stopWatch.getSplitNanoTime();
        });
        assertEquals("Stopwatch must be split to get the split time.", exception.getMessage());
    }

    @Test
    public void testGetSplitNanoTime_ReturnsCorrectTime_WhenSplit() throws Exception {
        // Arrange: Start and split the stopwatch
        invokePrivateMethod("start");
        // Simulate some elapsed time
        Thread.sleep(100);
        invokePrivateMethod("split");
        // Act: Get split time
        long splitTime = stopWatch.getSplitNanoTime();
        // Assert: Check that the split time is approximately equal to the elapsed time in nanoseconds
        // 100 milliseconds in nanoseconds
        long expectedNanoTime = 100_000_000;
        assertTrue(splitTime >= expectedNanoTime - 1_000_000 && splitTime <= expectedNanoTime + 1_000_000);
    }

    // Reflection method to invoke private methods
    private void invokePrivateMethod(String methodName) throws Exception {
        java.lang.reflect.Method method = StopWatch.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(stopWatch);
    }
}
