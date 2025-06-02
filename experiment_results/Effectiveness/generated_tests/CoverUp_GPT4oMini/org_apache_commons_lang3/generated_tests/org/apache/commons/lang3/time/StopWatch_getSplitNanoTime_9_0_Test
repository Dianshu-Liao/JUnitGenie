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
    public void testGetSplitNanoTimeThrowsExceptionWhenNotSplit() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            stopWatch.getSplitNanoTime();
        });
        assertEquals("Stopwatch must be split to get the split time.", exception.getMessage());
    }

    @Test
    public void testGetSplitNanoTimeReturnsCorrectValue() {
        stopWatch.start();
        stopWatch.split();
        // Simulate some elapsed time
        try {
            // Sleep for 100 milliseconds
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        stopWatch.stop();
        long splitNanoTime = stopWatch.getSplitNanoTime();
        // Ensure that the split time is positive
        assertTrue(splitNanoTime > 0);
    }

    @Test
    public void testGetSplitNanoTimeAfterUnsplitThrowsException() {
        stopWatch.start();
        stopWatch.split();
        stopWatch.unsplit();
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            stopWatch.getSplitNanoTime();
        });
        assertEquals("Stopwatch has not been split.", exception.getMessage());
    }

    @Test
    public void testGetSplitNanoTimeWithMultipleSplits() {
        stopWatch.start();
        stopWatch.split();
        try {
            // Sleep for 50 milliseconds
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        stopWatch.stop();
        long firstSplitTime = stopWatch.getSplitNanoTime();
        stopWatch.reset();
        stopWatch.start();
        stopWatch.split();
        try {
            // Sleep for 75 milliseconds
            Thread.sleep(75);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        stopWatch.stop();
        long secondSplitTime = stopWatch.getSplitNanoTime();
        // Ensure the second split time is greater than the first
        assertTrue(secondSplitTime > firstSplitTime);
    }
}
