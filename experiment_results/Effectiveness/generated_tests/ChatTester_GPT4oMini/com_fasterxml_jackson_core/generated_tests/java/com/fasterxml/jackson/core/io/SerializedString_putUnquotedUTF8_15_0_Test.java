package com.fasterxml.jackson.core.io;

import java.nio.ByteBuffer;
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
        serializedString = new SerializedString("testString");
    }

    @Test
    public void testPutUnquotedUTF8_Success() {
        ByteBuffer buffer = ByteBuffer.allocate(50);
        int result = serializedString.putUnquotedUTF8(buffer);
        // "testString" has 10 bytes in UTF-8
        assertEquals(10, result);
        assertEquals(10, buffer.position());
    }

    @Test
    public void testPutUnquotedUTF8_BufferTooSmall() {
        ByteBuffer buffer = ByteBuffer.allocate(5);
        int result = serializedString.putUnquotedUTF8(buffer);
        assertEquals(-1, result);
        assertEquals(0, buffer.position());
    }

    @Test
    public void testPutUnquotedUTF8_BufferExactlyFull() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        int result = serializedString.putUnquotedUTF8(buffer);
        assertEquals(10, result);
        assertEquals(10, buffer.position());
    }

    @Test
    public void testPutUnquotedUTF8_NullValue() throws Exception {
        // Use reflection to set _value to null
        java.lang.reflect.Field valueField = SerializedString.class.getDeclaredField("_value");
        valueField.setAccessible(true);
        valueField.set(serializedString, null);
        ByteBuffer buffer = ByteBuffer.allocate(50);
        int result = serializedString.putUnquotedUTF8(buffer);
        assertEquals(0, result);
        assertEquals(0, buffer.position());
    }
}
