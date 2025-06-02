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
        serializedString = new SerializedString("test");
    }

    @Test
    public void testPutUnquotedUTF8_Success() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        int length = serializedString.putUnquotedUTF8(buffer);
        assertEquals(4, length);
        buffer.flip();
        byte[] expectedBytes = "test".getBytes();
        byte[] actualBytes = new byte[length];
        buffer.get(actualBytes);
        assertEquals(new String(expectedBytes), new String(actualBytes));
    }

    @Test
    public void testPutUnquotedUTF8_BufferTooSmall() {
        ByteBuffer buffer = ByteBuffer.allocate(3);
        int length = serializedString.putUnquotedUTF8(buffer);
        assertEquals(-1, length);
    }

    @Test
    public void testPutUnquotedUTF8_NullBuffer() {
        assertThrows(NullPointerException.class, () -> {
            serializedString.putUnquotedUTF8(null);
        });
    }

    @Test
    public void testPutUnquotedUTF8_EmptyString() {
        serializedString = new SerializedString("");
        ByteBuffer buffer = ByteBuffer.allocate(10);
        int length = serializedString.putUnquotedUTF8(buffer);
        assertEquals(0, length);
        buffer.flip();
        byte[] actualBytes = new byte[length];
        buffer.get(actualBytes);
        assertEquals("", new String(actualBytes));
    }

    @Test
    public void testPutUnquotedUTF8_SingleCharacter() {
        serializedString = new SerializedString("a");
        ByteBuffer buffer = ByteBuffer.allocate(10);
        int length = serializedString.putUnquotedUTF8(buffer);
        assertEquals(1, length);
        buffer.flip();
        byte[] expectedBytes = "a".getBytes();
        byte[] actualBytes = new byte[length];
        buffer.get(actualBytes);
        assertEquals(new String(expectedBytes), new String(actualBytes));
    }

    @Test
    public void testPutUnquotedUTF8_MultipleCharacters() {
        serializedString = new SerializedString("abc");
        ByteBuffer buffer = ByteBuffer.allocate(10);
        int length = serializedString.putUnquotedUTF8(buffer);
        assertEquals(3, length);
        buffer.flip();
        byte[] expectedBytes = "abc".getBytes();
        byte[] actualBytes = new byte[length];
        buffer.get(actualBytes);
        assertEquals(new String(expectedBytes), new String(actualBytes));
    }
}
