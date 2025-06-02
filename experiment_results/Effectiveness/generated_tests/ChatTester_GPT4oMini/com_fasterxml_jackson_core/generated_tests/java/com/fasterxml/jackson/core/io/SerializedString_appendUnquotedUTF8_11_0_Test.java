package com.fasterxml.jackson.core.io;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.nio.ByteBuffer;
import java.util.Objects;
import com.fasterxml.jackson.core.SerializableString;

public class SerializedString_appendUnquotedUTF8_11_0_Test {

    private SerializedString serializedString;

    @BeforeEach
    public void setUp() {
        serializedString = new SerializedString("testValue");
    }

    @Test
    public void testAppendUnquotedUTF8_NullReference() throws Exception {
        // Prepare the buffer
        byte[] buffer = new byte[20];
        int offset = 0;
        // Invoke the focal method using reflection
        Method method = SerializedString.class.getDeclaredMethod("appendUnquotedUTF8", byte[].class, int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(serializedString, buffer, offset);
        // Validate the result
        // "testValue" is 9 bytes in UTF-8
        assertEquals(9, result);
        assertArrayEquals("testValue".getBytes("UTF-8"), java.util.Arrays.copyOf(buffer, result));
    }

    @Test
    public void testAppendUnquotedUTF8_InsufficientBuffer() throws Exception {
        // Prepare the buffer that is too small
        byte[] buffer = new byte[5];
        int offset = 0;
        // Invoke the focal method using reflection
        Method method = SerializedString.class.getDeclaredMethod("appendUnquotedUTF8", byte[].class, int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(serializedString, buffer, offset);
        // Validate the result
        assertEquals(-1, result);
    }

    @Test
    public void testAppendUnquotedUTF8_ValidCase() throws Exception {
        // Prepare a buffer with sufficient size
        byte[] buffer = new byte[20];
        int offset = 5;
        // Invoke the focal method using reflection
        Method method = SerializedString.class.getDeclaredMethod("appendUnquotedUTF8", byte[].class, int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(serializedString, buffer, offset);
        // Validate the result
        assertEquals(9, result);
        assertArrayEquals("testValue".getBytes("UTF-8"), java.util.Arrays.copyOfRange(buffer, offset, offset + result));
    }

    @Test
    public void testAppendUnquotedUTF8_OffsetBeyondBuffer() throws Exception {
        // Prepare a buffer with sufficient size
        byte[] buffer = new byte[10];
        // offset exceeds buffer length
        int offset = 10;
        // Invoke the focal method using reflection
        Method method = SerializedString.class.getDeclaredMethod("appendUnquotedUTF8", byte[].class, int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(serializedString, buffer, offset);
        // Validate the result
        assertEquals(-1, result);
    }
}
