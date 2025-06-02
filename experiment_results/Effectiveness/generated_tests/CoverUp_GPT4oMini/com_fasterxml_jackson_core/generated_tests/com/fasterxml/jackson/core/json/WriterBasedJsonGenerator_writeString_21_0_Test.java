package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
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

public class WriterBasedJsonGenerator_writeString_21_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter stringWriter;

    @BeforeEach
    public void setUp() {
        stringWriter = new StringWriter();
        IOContext ioContext = new IOContext(null, null, null, null, null, true);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, stringWriter, '"');
    }

    @Test
    public void testWriteString_ValidInput() throws Exception {
        char[] input = "Hello".toCharArray();
        generator.writeString(input, 0, input.length);
        assertEquals("\"Hello\"", stringWriter.toString());
    }

    @Test
    public void testWriteString_EmptyInput() throws Exception {
        char[] input = "".toCharArray();
        generator.writeString(input, 0, input.length);
        assertEquals("\"\"", stringWriter.toString());
    }

    @Test
    public void testWriteString_NullInput() {
        assertThrows(NullPointerException.class, () -> {
            generator.writeString(null, 0, 5);
        });
    }

    @Test
    public void testWriteString_WithOffsetAndLength() throws Exception {
        char[] input = "Hello, World!".toCharArray();
        // Write "World!"
        generator.writeString(input, 7, 6);
        assertEquals("\"World!\"", stringWriter.toString());
    }

    @Test
    public void testWriteString_LargeInput() throws Exception {
        char[] input = new char[100];
        for (int i = 0; i < input.length; i++) {
            // Fill with 'a'
            input[i] = 'a';
        }
        generator.writeString(input, 0, input.length);
        String expected = "\"" + new String(input) + "\"";
        assertEquals(expected, stringWriter.toString());
    }

    @Test
    public void testWriteString_HandlesFlush() throws Exception {
        // Set the output buffer to a smaller size for testing flush
        Method setOutputBufferMethod = WriterBasedJsonGenerator.class.getDeclaredMethod("setOutputBuffer", char[].class);
        setOutputBufferMethod.setAccessible(true);
        char[] smallBuffer = new char[10];
        setOutputBufferMethod.invoke(generator, (Object) smallBuffer);
        char[] input = "Test string that is longer than the buffer".toCharArray();
        generator.writeString(input, 0, input.length);
        String expected = "\"Test string that is longer than the buffer\"";
        assertEquals(expected, stringWriter.toString());
    }
}
