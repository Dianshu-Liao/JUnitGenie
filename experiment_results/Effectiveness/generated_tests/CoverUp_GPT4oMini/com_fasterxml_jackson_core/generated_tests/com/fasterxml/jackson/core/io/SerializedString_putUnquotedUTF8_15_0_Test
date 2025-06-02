package com.fasterxml.jackson.core.io;

import java.nio.ByteBuffer;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.util.Objects;
import com.fasterxml.jackson.core.SerializableString;

public class SerializedString_putUnquotedUTF8_15_0_Test {

    private SerializedString serializedString;

    @BeforeEach
    public void setUp() {
        serializedString = new SerializedString("test");
    }

    @Test
    public void testPutUnquotedUTF8_ValidBuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        int result = serializedString.putUnquotedUTF8(buffer);
        assertEquals(4, result);
        assertEquals("test", new String(buffer.array(), 0, result, java.nio.charset.StandardCharsets.UTF_8));
    }

    @Test
    public void testPutUnquotedUTF8_BufferTooSmall() {
        ByteBuffer buffer = ByteBuffer.allocate(3);
        int result = serializedString.putUnquotedUTF8(buffer);
        assertEquals(-1, result);
    }

    @Test
    public void testPutUnquotedUTF8_EmptyString() {
        SerializedString emptyString = new SerializedString("");
        ByteBuffer buffer = ByteBuffer.allocate(10);
        int result = emptyString.putUnquotedUTF8(buffer);
        assertEquals(0, result);
        assertEquals("", new String(buffer.array(), 0, result, java.nio.charset.StandardCharsets.UTF_8));
    }

    @Test
    public void testPutUnquotedUTF8_NullValue() throws Exception {
        Method method = SerializedString.class.getDeclaredMethod("putUnquotedUTF8", ByteBuffer.class);
        method.setAccessible(true);
        SerializedString nullValueString = new SerializedString(null);
        ByteBuffer buffer = ByteBuffer.allocate(10);
        int result = (int) method.invoke(nullValueString, buffer);
        assertEquals(-1, result);
    }
}
