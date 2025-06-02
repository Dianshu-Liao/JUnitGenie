package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.util.Arrays;
import com.fasterxml.jackson.core.util.TextBuffer;

public class JsonStringEncoder__appendByte_10_0_Test {

    private JsonStringEncoder encoder;

    @BeforeEach
    public void setUp() {
        encoder = JsonStringEncoder.getInstance();
    }

    @Test
    public void testAppendByteStandardEscape() throws Exception {
        ByteArrayBuilder byteArrayBuilder = new ByteArrayBuilder();
        // ASCII character
        int ch = 'A';
        // standard escape
        int esc = -1;
        // starting pointer
        int ptr = 0;
        // Invoke the private method using reflection
        Method method = JsonStringEncoder.class.getDeclaredMethod("_appendByte", int.class, int.class, ByteArrayBuilder.class, int.class);
        method.setAccessible(true);
        int newPtr = (int) method.invoke(encoder, ch, esc, byteArrayBuilder, ptr);
        // Validate the output
        byte[] expected = new byte[] { '\\', 'u', '0', '0', '4', '1' };
        assertArrayEquals(expected, byteArrayBuilder.getCurrentSegment());
        assertEquals(expected.length, newPtr);
    }

    @Test
    public void testAppendByteTwoCharEscape() throws Exception {
        ByteArrayBuilder byteArrayBuilder = new ByteArrayBuilder();
        // quote character
        int ch = '\"';
        // ASCII for quote
        int esc = 34;
        // starting pointer
        int ptr = 0;
        // Invoke the private method using reflection
        Method method = JsonStringEncoder.class.getDeclaredMethod("_appendByte", int.class, int.class, ByteArrayBuilder.class, int.class);
        method.setAccessible(true);
        int newPtr = (int) method.invoke(encoder, ch, esc, byteArrayBuilder, ptr);
        // Validate the output
        byte[] expected = new byte[] { '\"' };
        assertArrayEquals(expected, byteArrayBuilder.getCurrentSegment());
        assertEquals(expected.length, newPtr);
    }

    @Test
    public void testAppendByteHighUnicode() throws Exception {
        ByteArrayBuilder byteArrayBuilder = new ByteArrayBuilder();
        // Unicode for grinning face emoji
        int ch = 0x1F600;
        // standard escape
        int esc = -1;
        // starting pointer
        int ptr = 0;
        // Invoke the private method using reflection
        Method method = JsonStringEncoder.class.getDeclaredMethod("_appendByte", int.class, int.class, ByteArrayBuilder.class, int.class);
        method.setAccessible(true);
        int newPtr = (int) method.invoke(encoder, ch, esc, byteArrayBuilder, ptr);
        // Validate the output
        byte[] expected = new byte[] { '\\', 'u', 'd', '8', '0', '0', '\\', 'u', 'd', 'c', '0', '0' };
        assertArrayEquals(expected, byteArrayBuilder.getCurrentSegment());
        assertEquals(expected.length, newPtr);
    }
}
