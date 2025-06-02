package com.fasterxml.jackson.core.io;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.util.Arrays;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;

public class JsonStringEncoder__appendByte_10_0_Test {

    private JsonStringEncoder encoder;

    private ByteArrayBuilder byteArrayBuilder;

    @BeforeEach
    public void setUp() {
        encoder = new JsonStringEncoder();
        byteArrayBuilder = new ByteArrayBuilder();
    }

    @Test
    public void testAppendByteStandardEscape() throws Exception {
        // Setup
        // example character
        int ch = 0x1234;
        // standard escape
        int esc = -1;
        // starting pointer
        int ptr = 0;
        // Invoke the private method using reflection
        Method method = JsonStringEncoder.class.getDeclaredMethod("_appendByte", int.class, int.class, ByteArrayBuilder.class, int.class);
        method.setAccessible(true);
        // Execute
        int length = (int) method.invoke(encoder, ch, esc, byteArrayBuilder, ptr);
        // Verify
        byte[] expected = new byte[] { '\\', 'u', '1', '2', '3', '4' };
        assertArrayEquals(expected, byteArrayBuilder.getCurrentSegment());
        assertEquals(expected.length, length);
    }

    @Test
    public void testAppendByteSimpleEscape() throws Exception {
        // Setup
        // example character (double quote)
        int ch = '\"';
        // escape for double quote
        int esc = 34;
        // starting pointer
        int ptr = 0;
        // Invoke the private method using reflection
        Method method = JsonStringEncoder.class.getDeclaredMethod("_appendByte", int.class, int.class, ByteArrayBuilder.class, int.class);
        method.setAccessible(true);
        // Execute
        int length = (int) method.invoke(encoder, ch, esc, byteArrayBuilder, ptr);
        // Verify
        // expecting \"
        byte[] expected = new byte[] { '\\', (byte) esc };
        assertArrayEquals(expected, byteArrayBuilder.getCurrentSegment());
        assertEquals(expected.length, length);
    }

    @Test
    public void testAppendByteHighCharacter() throws Exception {
        // Setup
        // character above 0xFF
        int ch = 0x10000;
        // standard escape
        int esc = -1;
        // starting pointer
        int ptr = 0;
        // Invoke the private method using reflection
        Method method = JsonStringEncoder.class.getDeclaredMethod("_appendByte", int.class, int.class, ByteArrayBuilder.class, int.class);
        method.setAccessible(true);
        // Execute
        int length = (int) method.invoke(encoder, ch, esc, byteArrayBuilder, ptr);
        // Verify
        byte[] expected = new byte[] { '\\', 'u', '1', '0', '0', '0', '0' };
        assertArrayEquals(expected, byteArrayBuilder.getCurrentSegment());
        assertEquals(expected.length, length);
    }

    @Test
    public void testAppendByteLowCharacter() throws Exception {
        // Setup
        // character below 0xFF
        int ch = 0x7;
        // standard escape
        int esc = -1;
        // starting pointer
        int ptr = 0;
        // Invoke the private method using reflection
        Method method = JsonStringEncoder.class.getDeclaredMethod("_appendByte", int.class, int.class, ByteArrayBuilder.class, int.class);
        method.setAccessible(true);
        // Execute
        int length = (int) method.invoke(encoder, ch, esc, byteArrayBuilder, ptr);
        // Verify
        byte[] expected = new byte[] { '\\', 'u', '0', '0', '0', '7' };
        assertArrayEquals(expected, byteArrayBuilder.getCurrentSegment());
        assertEquals(expected.length, length);
    }
}
