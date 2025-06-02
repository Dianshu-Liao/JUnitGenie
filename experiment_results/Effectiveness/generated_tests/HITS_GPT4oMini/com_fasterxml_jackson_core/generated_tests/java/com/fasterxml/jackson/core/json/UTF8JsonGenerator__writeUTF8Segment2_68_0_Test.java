package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.BufferRecycler;
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

public class UTF8JsonGenerator__writeUTF8Segment2_68_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        BufferRecycler bufferRecycler = new BufferRecycler();
        ioContext = new IOContext(bufferRecycler, outputStream, true);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    private void invokeWriteUTF8Segment2(byte[] input, int offset, int length) throws Exception {
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeUTF8Segment2", byte[].class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(generator, input, offset, length);
    }

    @Test
    public void testWriteUTF8Segment2_SimpleBytes() throws Exception {
        byte[] input = new byte[] { 65, 66, 67 };
        invokeWriteUTF8Segment2(input, 0, input.length);
        byte[] expectedOutput = new byte[] { 65, 66, 67 };
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    public void testWriteUTF8Segment2_ContainsEscapes() throws Exception {
        byte[] input = new byte[] { 34, 92, 65 };
        invokeWriteUTF8Segment2(input, 0, input.length);
        byte[] expectedOutput = new byte[] { 92, 34, 92, 65 };
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    public void testWriteUTF8Segment2_NonASCIICharacters() throws Exception {
        byte[] input = new byte[] { -128, -1, -64 };
        invokeWriteUTF8Segment2(input, 0, input.length);
        byte[] expectedOutput = new byte[] { 92, 117, (byte) 128, 92, 117, (byte) 255, 92, 117, (byte) 192 };
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    public void testWriteUTF8Segment2_BufferFlush() throws Exception {
        byte[] input = new byte[512];
        for (int i = 0; i < input.length; i++) {
            input[i] = (byte) (i % 256);
        }
        invokeWriteUTF8Segment2(input, 0, input.length);
        assertArrayEquals(input, outputStream.toByteArray());
    }

    @Test
    public void testWriteUTF8Segment2_ThrowsExceptionOnInvalidInput() {
        byte[] input = null;
        assertThrows(NullPointerException.class, () -> {
            invokeWriteUTF8Segment2(input, 0, 10);
        });
    }
}
