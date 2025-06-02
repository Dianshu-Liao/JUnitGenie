package org.apache.commons.compress.archivers.zip;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
        circularBuffer = new CircularBuffer(10);
    }

    @Test
    void testCopy() throws Exception {
        // Fill the buffer with initial values
        for (int i = 0; i < 5; i++) {
            circularBuffer.put(i);
        }
        // Copy values from the buffer to the end of the buffer
        invokeCopy(circularBuffer, 3, 2);
        // Expected buffer state after copy
        byte[] expectedBuffer = new byte[10];
        expectedBuffer[0] = 0;
        expectedBuffer[1] = 1;
        expectedBuffer[2] = 2;
        expectedBuffer[3] = 3;
        expectedBuffer[4] = 4;
        // Copying 2 values starting from index (5-3) = 2
        expectedBuffer[5] = 2;
        // Copying 2 values
        expectedBuffer[6] = 3;
        // Remaining values should be 0
        expectedBuffer[7] = 0;
        expectedBuffer[8] = 0;
        expectedBuffer[9] = 0;
        // Check the buffer state
        assertArrayEquals(expectedBuffer, getBuffer(circularBuffer));
    }

    @Test
    void testCopyWithWrapAround() throws Exception {
        // Fill the buffer to wrap around
        for (int i = 0; i < 10; i++) {
            circularBuffer.put(i);
        }
        // Copy values from the buffer to the end of the buffer
        invokeCopy(circularBuffer, 5, 5);
        // Expected buffer state after copy
        byte[] expectedBuffer = new byte[10];
        // Wraps around
        expectedBuffer[0] = 5;
        expectedBuffer[1] = 6;
        expectedBuffer[2] = 7;
        expectedBuffer[3] = 8;
        expectedBuffer[4] = 9;
        // Copying 5 values starting from index (10-5) = 5
        expectedBuffer[5] = 0;
        // Copying 5 values
        expectedBuffer[6] = 1;
        expectedBuffer[7] = 2;
        expectedBuffer[8] = 3;
        expectedBuffer[9] = 4;
        // Check the buffer state
        assertArrayEquals(expectedBuffer, getBuffer(circularBuffer));
    }

    private void invokeCopy(CircularBuffer buffer, int distance, int length) throws Exception {
        Method method = CircularBuffer.class.getDeclaredMethod("copy", int.class, int.class);
        method.setAccessible(true);
        method.invoke(buffer, distance, length);
    }

    private byte[] getBuffer(CircularBuffer buffer) throws Exception {
        Field field = CircularBuffer.class.getDeclaredField("buffer");
        field.setAccessible(true);
        return (byte[]) field.get(buffer);
    }
}
