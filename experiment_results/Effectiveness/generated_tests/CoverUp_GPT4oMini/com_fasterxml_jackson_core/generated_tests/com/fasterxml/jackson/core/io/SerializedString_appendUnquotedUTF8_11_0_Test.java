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
        serializedString = new SerializedString("test");
    }

    @Test
    public void testAppendUnquotedUTF8_ValidBuffer() {
        byte[] buffer = new byte[10];
        int bytesWritten = serializedString.appendUnquotedUTF8(buffer, 0);
        assertEquals(4, bytesWritten);
        assertArrayEquals(new byte[] { 116, 101, 115, 116 }, buffer);
    }

    @Test
    public void testAppendUnquotedUTF8_BufferTooSmall() {
        byte[] buffer = new byte[3];
        int bytesWritten = serializedString.appendUnquotedUTF8(buffer, 0);
        assertEquals(-1, bytesWritten);
    }

    @Test
    public void testAppendUnquotedUTF8_OffsetTooLarge() {
        byte[] buffer = new byte[10];
        int bytesWritten = serializedString.appendUnquotedUTF8(buffer, 10);
        assertEquals(-1, bytesWritten);
    }

    @Test
    public void testAppendUnquotedUTF8_InitialEncoding() throws Exception {
        byte[] buffer = new byte[10];
        Method method = SerializedString.class.getDeclaredMethod("appendUnquotedUTF8", byte[].class, int.class);
        method.setAccessible(true);
        // First call should trigger encoding
        int bytesWritten = (int) method.invoke(serializedString, buffer, 0);
        assertEquals(4, bytesWritten);
        // Second call should not trigger encoding again
        bytesWritten = (int) method.invoke(serializedString, buffer, 0);
        assertEquals(4, bytesWritten);
    }
}
