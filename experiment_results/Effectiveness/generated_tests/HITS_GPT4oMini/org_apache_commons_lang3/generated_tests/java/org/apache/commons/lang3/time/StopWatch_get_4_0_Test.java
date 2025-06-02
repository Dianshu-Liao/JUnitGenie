package org.apache.commons.lang3.time;

import java.time.Duration;
import java.util.function.Supplier;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.Instant;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableRunnable;
import org.apache.commons.lang3.function.FailableSupplier;

public class StopWatch_get_4_0_Test {

    private StopWatch stopWatch;

    @BeforeEach
    public void setUp() {
        stopWatch = new StopWatch();
    }

    @Test
    public void testGet_WithSupplier_ReturnsValue() {
        Supplier<String> supplier = () -> "Test Value";
        String result = stopWatch.get(supplier);
        assertEquals("Test Value", result);
    }

    @Test
    public void testGet_WithNullSupplier_ThrowsException() {
        Supplier<String> supplier = null;
        assertThrows(NullPointerException.class, () -> {
            stopWatch.get(supplier);
        });
    }

    @Test
    public void testGet_WithSupplierThatThrowsException_PropagatesException() {
        Supplier<String> supplier = () -> {
            throw new RuntimeException("Supplier Exception");
        };
        Exception exception = assertThrows(RuntimeException.class, () -> {
            stopWatch.get(supplier);
        });
        assertEquals("Supplier Exception", exception.getMessage());
    }

    @Test
    public void testGet_StartsAndSuspendsStopWatch() {
        Supplier<String> supplier = () -> {
            try {
                // Simulate work
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Done";
        };
        String result = stopWatch.get(supplier);
        assertEquals("Done", result);
        assertTrue(stopWatch.getDuration().toMillis() >= 100);
    }

    @Test
    public void testGet_WhenStopWatchIsRunning_DoesNotThrowException() {
        Supplier<String> supplier = () -> "Running Test";
        assertDoesNotThrow(() -> stopWatch.get(supplier));
    }
}
