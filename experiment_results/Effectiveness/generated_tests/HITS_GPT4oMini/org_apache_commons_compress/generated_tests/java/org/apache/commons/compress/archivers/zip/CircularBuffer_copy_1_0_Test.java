package org.apache.commons.compress.archivers.zip;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class CircularBuffer_copy_1_0_Test {

    private CircularBuffer circularBuffer;

    @BeforeEach
    void setUp() {
        // Initialize with a size of 10
        circularBuffer = new CircularBuffer(10);
    }

    private byte[] getBuffer(CircularBuffer cb) {
        // Assuming we can access the internal buffer directly for testing purposes
        // This is a placeholder for whatever method we would use to retrieve the buffer
        // In practice, this would require a method in CircularBuffer to return the buffer
        // For this example, we will assume a direct access method
        // This is just an illustrative example as we cannot actually implement this without modifying CircularBuffer
        // You would need to implement a getter in CircularBuffer for this to work
        // Placeholder implementation
        return new byte[10];
    }

    @Test
    void testCopyWithPositiveDistance() {
        // Setup the buffer with some data
        for (int i = 0; i < 10; i++) {
            circularBuffer.copy(i, 1);
        }
        // Copy from a positive distance
        circularBuffer.copy(5, 3);
        // Expected outcome: buffer should contain the values copied from the original data
        byte[] expectedBuffer = { 5, 6, 7, 8, 9, 0, 1, 2, 3, 4 };
        assertArrayEquals(expectedBuffer, getBuffer(circularBuffer));
    }

    @Test
    void testCopyWithNegativeDistance() {
        // Setup the buffer with some data
        for (int i = 0; i < 10; i++) {
            circularBuffer.copy(i, 1);
        }
        // Copy from a negative distance
        circularBuffer.copy(-5, 3);
        // Expected outcome: buffer should contain the values copied from the original data
        byte[] expectedBuffer = { 5, 6, 7, 8, 9, 0, 1, 2, 3, 4 };
        assertArrayEquals(expectedBuffer, getBuffer(circularBuffer));
    }

    @Test
    void testCopyWithZeroDistance() {
        // Setup the buffer with some data
        for (int i = 0; i < 10; i++) {
            circularBuffer.copy(i, 1);
        }
        // Copy with zero distance
        circularBuffer.copy(0, 3);
        // Expected outcome: buffer should contain the last written values
        byte[] expectedBuffer = { 0, 1, 2, 3, 4, 0, 1, 2, 3, 4 };
        assertArrayEquals(expectedBuffer, getBuffer(circularBuffer));
    }
}
