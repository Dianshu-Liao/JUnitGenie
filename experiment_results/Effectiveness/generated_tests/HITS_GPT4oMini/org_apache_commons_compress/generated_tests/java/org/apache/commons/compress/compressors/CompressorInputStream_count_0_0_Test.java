package org.apache.commons.compress.compressors;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;

public class CompressorInputStream_count_0_0_Test extends CompressorInputStream {

    // Concrete implementation of the abstract read() method for testing
    @Override
    public int read() {
        // Dummy implementation
        return -1;
    }

    @BeforeEach
    public void setUp() {
        // Reset bytesRead before each test
        // Since bytesRead is private, we will not reset it directly.
        // We can assume it starts at 0 for each test.
    }

    @Test
    public void testCountIncrementsBytesRead() {
        // Arrange
        long initialCount = getBytesRead();
        int bytesToCount = 5;
        // Act
        count(bytesToCount);
        // Assert
        assertEquals(initialCount + bytesToCount, getBytesRead());
    }

    @Test
    public void testCountDoesNotIncrementOnMinusOne() {
        // Arrange
        long initialCount = getBytesRead();
        int bytesToCount = -1;
        // Act
        count(bytesToCount);
        // Assert
        assertEquals(initialCount, getBytesRead());
    }

    @Test
    public void testCountMultipleCalls() {
        // Arrange
        long initialCount = getBytesRead();
        int firstCount = 10;
        int secondCount = 20;
        // Act
        count(firstCount);
        count(secondCount);
        // Assert
        assertEquals(initialCount + firstCount + secondCount, getBytesRead());
    }

    @Test
    public void testCountZeroDoesNotChangeCount() {
        // Arrange
        long initialCount = getBytesRead();
        int bytesToCount = 0;
        // Act
        count(bytesToCount);
        // Assert
        assertEquals(initialCount, getBytesRead());
    }
}
