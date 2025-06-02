package com.fasterxml.jackson.core.json;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.IOContext;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.NumberOutput;

public class UTF8JsonGenerator__writeStringSegmentASCII2_60_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    private char[] charBuffer;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = Mockito.mock(IOContext.class);
        ObjectCodec codec = Mockito.mock(ObjectCodec.class);
        generator = new UTF8JsonGenerator(ioContext, 0, codec, outputStream, '"');
        generator._outputBuffer = new byte[512];
        generator._outputTail = 0;
        // Fixed the assignment of _outputEnd to use a setter method or constructor if available
        // Assuming _outputEnd is a protected field, we can use reflection to set it
        try {
            java.lang.reflect.Field field = UTF8JsonGenerator.class.getDeclaredField("_outputEnd");
            field.setAccessible(true);
            field.setInt(generator, 512);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        generator._outputEscapes = new int[128];
        generator._maximumNonEscapedChar = 127;
    }

    @Test
    public void testWriteStringSegmentASCII2_OnlyASCII() throws Exception {
        charBuffer = new char[] { 'H', 'e', 'l', 'l', 'o' };
        invokeWriteStringSegmentASCII2(charBuffer, 0, charBuffer.length);
        assertEquals("Hello", outputStream.toString("UTF-8"));
    }

    @Test
    public void testWriteStringSegmentASCII2_WithEscapes() throws Exception {
        generator._outputEscapes['H'] = 0;
        generator._outputEscapes['e'] = 0;
        generator._outputEscapes['l'] = 0;
        generator._outputEscapes['o'] = 0;
        generator._outputEscapes['\n'] = 110;
        charBuffer = new char[] { 'H', 'e', 'l', 'l', 'o', '\n' };
        invokeWriteStringSegmentASCII2(charBuffer, 0, charBuffer.length);
        assertEquals("Hello\\n", outputStream.toString("UTF-8"));
    }

    @Test
    public void testWriteStringSegmentASCII2_NonASCII() throws Exception {
        generator._maximumNonEscapedChar = 0x20;
        generator._outputEscapes['H'] = 0;
        generator._outputEscapes['e'] = 0;
        generator._outputEscapes['l'] = 0;
        generator._outputEscapes['o'] = 0;
        generator._outputEscapes['€'] = 0;
        charBuffer = new char[] { 'H', 'e', 'l', 'l', 'o', '€' };
        invokeWriteStringSegmentASCII2(charBuffer, 0, charBuffer.length);
        assertTrue(outputStream.toString("UTF-8").contains("€"));
    }

    @Test
    public void testWriteStringSegmentASCII2_BufferFlush() throws Exception {
        generator._outputBuffer = new byte[10];
        generator._outputTail = 0;
        try {
            java.lang.reflect.Field field = UTF8JsonGenerator.class.getDeclaredField("_outputEnd");
            field.setAccessible(true);
            field.setInt(generator, 10);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        charBuffer = new char[] { 'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd' };
        invokeWriteStringSegmentASCII2(charBuffer, 0, charBuffer.length);
        String output = outputStream.toString("UTF-8");
        assertTrue(output.contains("Hello World"));
    }

    private void invokeWriteStringSegmentASCII2(char[] cbuf, int offset, int end) throws Exception {
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeStringSegmentASCII2", char[].class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(generator, cbuf, offset, end);
    }
}
