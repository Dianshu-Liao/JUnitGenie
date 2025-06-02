package org.apache.commons.compress.archivers.zip;

import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CircularBuffer_copy_1_0_Test {

    private CircularBuffer circularBuffer;

    @BeforeEach
    void setUp() {
        circularBuffer = new CircularBuffer(5);
    }

    @Test
    void testCopyWithValidParameters() {
        // Setup the buffer with some data
        circularBuffer.put(1);
        circularBuffer.put(2);
        circularBuffer.put(3);
        circularBuffer.put(4);
        circularBuffer.put(5);
        // Copy data from distance 2, length 3
        circularBuffer.copy(2, 3);
        // Assert the expected state of the buffer
        assertArrayEquals(new byte[] { 4, 5, 1, 2, 3 }, getBuffer());
    }

    @Test
    void testCopyWithWrapAround() {
        // Setup the buffer with data
        circularBuffer.put(1);
        circularBuffer.put(2);
        circularBuffer.put(3);
        circularBuffer.put(4);
        circularBuffer.put(5);
        // Copy data from distance 4, length 3 (should wrap around)
        circularBuffer.copy(4, 3);
        // Assert the expected state of the buffer
        assertArrayEquals(new byte[] { 3, 4, 5, 1, 2 }, getBuffer());
    }

    @Test
    void testCopyWithZeroLength() {
        // Setup the buffer with data
        circularBuffer.put(1);
        circularBuffer.put(2);
        circularBuffer.put(3);
        circularBuffer.put(4);
        circularBuffer.put(5);
        // Copy with length 0
        circularBuffer.copy(1, 0);
        // Assert the buffer remains unchanged
        assertArrayEquals(new byte[] { 1, 2, 3, 4, 5 }, getBuffer());
    }

    @Test
    void testCopyWithNegativeDistance() {
        // Setup the buffer with data
        circularBuffer.put(1);
        circularBuffer.put(2);
        circularBuffer.put(3);
        circularBuffer.put(4);
        circularBuffer.put(5);
        // Copy with negative distance (should not change the buffer)
        circularBuffer.copy(-1, 3);
        // Assert the buffer remains unchanged
        assertArrayEquals(new byte[] { 1, 2, 3, 4, 5 }, getBuffer());
    }

    private byte[] getBuffer() {
        try {
            // Fixed line: using the correct type for the field
            java.lang.reflect.Field bufferField = CircularBuffer.class.getDeclaredField("buffer");
            bufferField.setAccessible(true);
            return (byte[]) bufferField.get(circularBuffer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
