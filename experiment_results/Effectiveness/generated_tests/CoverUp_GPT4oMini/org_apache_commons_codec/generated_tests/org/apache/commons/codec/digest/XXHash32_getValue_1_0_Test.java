package org.apache.commons.codec.digest;

import java.lang.reflect.Field;
import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static java.lang.Integer.rotateLeft;
import java.util.zip.Checksum;

public class XXHash32_getValue_1_0_Test {

    private XXHash32 xxHash32;

    @BeforeEach
    public void setUp() {
        xxHash32 = new XXHash32();
    }

    @Test
    public void testGetValueWithStateNotUpdated() throws Exception {
        // Set up the state for the test
        setField(xxHash32, "state", new int[] { 0, 0, 0, 0 });
        setField(xxHash32, "totalLen", 0);
        setField(xxHash32, "pos", 0);
        setField(xxHash32, "stateUpdated", false);
        // state[2] + PRIME5
        long expected = (0 + 374761393) & 0xffffffffL;
        long actual = xxHash32.getValue();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetValueWithStateUpdated() throws Exception {
        // Set up the state for the test
        setField(xxHash32, "state", new int[] { 1, 2, 3, 4 });
        setField(xxHash32, "totalLen", 8);
        setField(xxHash32, "pos", 4);
        setField(xxHash32, "stateUpdated", true);
        long expected = ((Integer.rotateLeft(1, 1) + Integer.rotateLeft(2, 7) + Integer.rotateLeft(3, 12) + Integer.rotateLeft(4, 18)) + 8) & 0xffffffffL;
        long actual = xxHash32.getValue();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetValueWithBufferData() throws Exception {
        // Set up the state for the test with buffer data
        setField(xxHash32, "state", new int[] { 0, 0, 0, 0 });
        setField(xxHash32, "totalLen", 16);
        setField(xxHash32, "pos", 8);
        setField(xxHash32, "stateUpdated", false);
        byte[] bufferData = new byte[16];
        for (int i = 0; i < bufferData.length; i++) {
            bufferData[i] = (byte) i;
        }
        setField(xxHash32, "buffer", bufferData);
        long actual = xxHash32.getValue();
        // Calculate expected value based on the buffer data and state
        // Adjust as per implementation specifics
        long expected = (0 + 374761393 + 16) & 0xffffffffL;
        assertEquals(expected, actual);
    }

    private void setField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
