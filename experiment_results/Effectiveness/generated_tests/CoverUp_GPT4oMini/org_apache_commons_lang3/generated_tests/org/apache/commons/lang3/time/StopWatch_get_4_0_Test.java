package org.apache.commons.lang3.time;

import java.time.Duration;
import java.util.function.Supplier;
import org.apache.commons.lang3.time.StopWatch;
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

class StopWatch_get_4_0_Test {

    private StopWatch stopWatch;

    @BeforeEach
    void setUp() {
        stopWatch = new StopWatch();
    }

    @Test
    void testGetSupplier() {
        // Arrange
        Supplier<String> supplier = () -> "Hello, World!";
        // Act
        String result = stopWatch.get(supplier);
        // Assert
        assertEquals("Hello, World!", result);
    }

    @Test
    void testGetSupplierWithException() {
        // Arrange
        Supplier<String> supplier = () -> {
            throw new RuntimeException("Supplier Exception");
        };
        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> {
            stopWatch.get(supplier);
        });
        assertEquals("Supplier Exception", exception.getMessage());
    }

    @Test
    void testGetSupplierWithStateChange() {
        // Arrange
        Supplier<Long> supplier = () -> {
            // Simulate some processing
            try {
                // Sleep for 100ms
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return stopWatch.getNanoTime();
        };
        // Act
        long nanoTimeBefore = stopWatch.getNanoTime();
        long result = stopWatch.get(supplier);
        long nanoTimeAfter = stopWatch.getNanoTime();
        // Assert
        assertTrue(result >= nanoTimeBefore);
        assertTrue(result <= nanoTimeAfter);
    }

    @Test
    void testGetSupplierWithSuspendedState() {
        // Arrange
        Supplier<String> supplier = () -> {
            // Simulate suspension within the supplier
            stopWatch.suspend();
            return "Suspended";
        };
        // Act & Assert
        assertThrows(IllegalStateException.class, () -> stopWatch.get(supplier));
    }
}
