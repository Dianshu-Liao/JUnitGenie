package com.fasterxml.jackson.core.json;

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
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;

public class UTF8JsonGenerator_writeRaw_26_0_Test {

    private ByteArrayOutputStream outputStream;

    private UTF8JsonGenerator generator;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        generator = new UTF8JsonGenerator(Mockito.mock(IOContext.class), 0, Mockito.mock(ObjectCodec.class), outputStream, '"');
    }

    @Test
    public void testWriteRaw_AsciiCharacter() throws Exception {
        // ASCII character
        char inputChar = 'A';
        invokeWriteRaw(inputChar);
        byte[] expectedOutput = new byte[] { (byte) inputChar };
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    public void testWriteRaw_2ByteCharacter() throws Exception {
        // 2-byte character
        char inputChar = 'é';
        invokeWriteRaw(inputChar);
        byte[] expectedOutput = new byte[] { (byte) 0xc3, (byte) 0xa9 };
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    public void testWriteRaw_3ByteCharacter() throws Exception {
        // 3-byte character
        char inputChar = '€';
        invokeWriteRaw(inputChar);
        byte[] expectedOutput = new byte[] { (byte) 0xe2, (byte) 0x82, (byte) 0xac };
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    public void testWriteRaw_BufferFlush() throws Exception {
        // Create a generator with a small buffer
        byte[] smallBuffer = new byte[5];
        generator = new UTF8JsonGenerator(Mockito.mock(IOContext.class), 0, Mockito.mock(ObjectCodec.class), outputStream, '"', smallBuffer, 0, true);
        // Fill the buffer to trigger a flush
        for (char ch = 0; ch < 5; ch++) {
            invokeWriteRaw(ch);
        }
        // Now write one more character to trigger flush
        invokeWriteRaw('A');
        // Verify the output contains the first 5 characters plus 'A'
        byte[] expectedOutput = new byte[] { 0, 1, 2, 3, 4, 'A' };
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    public void testWriteRaw_ExceptionOnFlush() throws Exception {
        // Mock the OutputStream to throw IOException
        outputStream = Mockito.mock(ByteArrayOutputStream.class);
        Mockito.doThrow(new IOException("Flush error")).when(outputStream).flush();
        generator = new UTF8JsonGenerator(Mockito.mock(IOContext.class), 0, Mockito.mock(ObjectCodec.class), outputStream, '"');
        assertThrows(IOException.class, () -> invokeWriteRaw('A'));
    }

    private void invokeWriteRaw(char ch) throws Exception {
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("writeRaw", char.class);
        method.setAccessible(true);
        method.invoke(generator, ch);
    }
}
