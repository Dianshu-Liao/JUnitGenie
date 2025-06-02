package com.fasterxml.jackson.core.io;

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
        serializedString = new SerializedString("Test String");
    }

    @Test
    public void testAppendUnquotedUTF8_Success() {
        byte[] buffer = new byte[50];
        int offset = 0;
        int length = serializedString.appendUnquotedUTF8(buffer, offset);
        byte[] expected = new byte[] { 'T', 'e', 's', 't', ' ', 'S', 't', 'r', 'i', 'n', 'g' };
        assertEquals(expected.length, length);
        assertArrayEquals(expected, new byte[] { buffer[0], buffer[1], buffer[2], buffer[3], buffer[4], buffer[5], buffer[6], buffer[7], buffer[8], buffer[9], buffer[10] });
    }

    @Test
    public void testAppendUnquotedUTF8_BufferTooSmall() {
        byte[] buffer = new byte[10];
        int offset = 0;
        int result = serializedString.appendUnquotedUTF8(buffer, offset);
        assertEquals(-1, result);
    }

    @Test
    public void testAppendUnquotedUTF8_OffsetTooLarge() {
        byte[] buffer = new byte[50];
        // invalid offset
        int offset = 100;
        int result = serializedString.appendUnquotedUTF8(buffer, offset);
        assertEquals(-1, result);
    }

    @Test
    public void testAppendUnquotedUTF8_NullBuffer() {
        int offset = 0;
        assertThrows(NullPointerException.class, () -> {
            serializedString.appendUnquotedUTF8(null, offset);
        });
    }

    @Test
    public void testAppendUnquotedUTF8_EmptyString() {
        serializedString = new SerializedString("");
        byte[] buffer = new byte[50];
        int offset = 0;
        int length = serializedString.appendUnquotedUTF8(buffer, offset);
        assertEquals(0, length);
        assertArrayEquals(new byte[0], new byte[] { buffer[0], buffer[1], buffer[2], buffer[3], buffer[4], buffer[5], buffer[6], buffer[7], buffer[8], buffer[9] });
    }
}
