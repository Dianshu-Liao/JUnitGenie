package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.NumberOutput;

public class UTF8JsonGenerator__handleLongCustomEscape_65_2_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        IOContext ioContext = new IOContext(null, null, null, false);
        outputStream = new ByteArrayOutputStream();
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testHandleLongCustomEscape_FlushesBufferWhenNeeded() throws Exception {
        byte[] outputBuffer = new byte[10];
        byte[] raw = new byte[] { 'a', 'b', 'c', 'd', 'e' };
        int outputPtr = 0;
        int outputEnd = outputBuffer.length;
        int remainingChars = 1;
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("_handleLongCustomEscape", byte[].class, int.class, int.class, byte[].class, int.class);
        method.setAccessible(true);
        // Call the method
        outputPtr = (int) method.invoke(generator, outputBuffer, outputPtr, outputEnd, raw, remainingChars);
        // Check the output
        assertArrayEquals(new byte[] { 'a', 'b', 'c', 'd', 'e' }, outputBuffer);
        assertEquals(5, outputPtr);
    }

    @Test
    public void testHandleLongCustomEscape_WritesRawDirectlyWhenBufferIsTooSmall() throws Exception {
        byte[] outputBuffer = new byte[5];
        byte[] raw = new byte[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
        int outputPtr = 0;
        int outputEnd = outputBuffer.length;
        int remainingChars = 3;
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("_handleLongCustomEscape", byte[].class, int.class, int.class, byte[].class, int.class);
        method.setAccessible(true);
        // Call the method
        outputPtr = (int) method.invoke(generator, outputBuffer, outputPtr, outputEnd, raw, remainingChars);
        // Check the output
        assertArrayEquals(new byte[] { 'a', 'b', 'c', 'd', 'e' }, outputBuffer);
        assertEquals(5, outputPtr);
        assertEquals("abcdefg", outputStream.toString());
    }

    @Test
    public void testHandleLongCustomEscape_FlushesBufferAgainWhenInvariantBroken() throws Exception {
        byte[] outputBuffer = new byte[10];
        byte[] raw = new byte[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
        int outputPtr = 0;
        int outputEnd = outputBuffer.length;
        int remainingChars = 1;
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("_handleLongCustomEscape", byte[].class, int.class, int.class, byte[].class, int.class);
        method.setAccessible(true);
        // Call the method
        outputPtr = (int) method.invoke(generator, outputBuffer, outputPtr, outputEnd, raw, remainingChars);
        // Check the output
        assertArrayEquals(new byte[] { 'a', 'b', 'c', 'd', 'e' }, outputBuffer);
        assertEquals(5, outputPtr);
        assertEquals("abcdefgh", outputStream.toString());
    }
}
