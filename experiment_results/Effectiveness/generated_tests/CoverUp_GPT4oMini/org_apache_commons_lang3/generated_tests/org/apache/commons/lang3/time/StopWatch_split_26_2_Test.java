package org.apache.commons.lang3.time;

import java.time.Duration;
import java.time.Instant;
import java.lang.reflect.Field;
import java.util.Objects;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableRunnable;
import org.apache.commons.lang3.function.FailableSupplier;

class StopWatch_split_26_2_Test {

    private StopWatch stopWatch;

    @BeforeEach
    void setUp() {
        stopWatch = new StopWatch();
    }

    @Test
    void split_shouldThrowException_whenNotRunning() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, stopWatch::split);
        assertEquals("Stopwatch is not running.", exception.getMessage());
    }

    @Test
    void split_shouldUpdateSplitState_whenRunning() {
        startStopWatch();
        stopWatch.split();
        assertEquals(getPrivateField("splitState", String.class), "SPLIT");
        assertNotEquals(0, getPrivateField("stopTimeNanos", Long.class));
    }

    @Test
    void getSplitDuration_shouldThrowException_whenNotSplit() {
        startStopWatch();
        IllegalStateException exception = assertThrows(IllegalStateException.class, stopWatch::getSplitDuration);
        assertEquals("Stopwatch must be split to get the split time.", exception.getMessage());
    }

    @Test
    void getSplitDuration_shouldReturnCorrectDuration_whenSplit() {
        startStopWatch();
        stopWatch.split();
        Duration splitDuration = stopWatch.getSplitDuration();
        assertTrue(splitDuration.toNanos() > 0);
    }

    private void startStopWatch() {
        // Using reflection to set the private field `runningState` to RUNNING
        setPrivateField("runningState", "RUNNING");
        // Setting start time
        setPrivateField("startTimeNanos", System.nanoTime());
        setPrivateField("startInstant", Instant.now());
    }

    private <T> T getPrivateField(String fieldName, Class<T> type) {
        try {
            Field field = StopWatch.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return type.cast(field.get(stopWatch));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setPrivateField(String fieldName, Object value) {
        try {
            Field field = StopWatch.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(stopWatch, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
