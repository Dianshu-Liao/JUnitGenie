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

public class WriterBasedJsonGenerator_writeRawLong_31_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    @BeforeEach
    public void setUp() {
        writer = new StringWriter();
        IOContext context = new IOContext(null, writer, true);
        generator = new WriterBasedJsonGenerator(context, 0, null, writer, '"');
    }

    private void invokeWriteRawLong(String input) throws Exception {
        Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("writeRawLong", String.class);
        method.setAccessible(true);
        method.invoke(generator, input);
    }

    @Test
    public void testWriteRawLong_SingleWrite() throws Exception {
        String input = "Hello, World!";
        invokeWriteRawLong(input);
        assertEquals(input, writer.toString());
    }

    @Test
    public void testWriteRawLong_MultipleWrites() throws Exception {
        String input = "This is a test string that is longer than the buffer size.";
        invokeWriteRawLong(input);
        assertEquals(input, writer.toString());
    }

    @Test
    public void testWriteRawLong_EmptyString() throws Exception {
        String input = "";
        invokeWriteRawLong(input);
        assertEquals(input, writer.toString());
    }

    @Test
    public void testWriteRawLong_SpecialCharacters() throws Exception {
        String input = "Special characters: \n\t\b\f\r\"\\";
        invokeWriteRawLong(input);
        assertEquals(input, writer.toString());
    }

    @Test
    public void testWriteRawLong_LongInput() throws Exception {
        StringBuilder longInput = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            longInput.append("A");
        }
        invokeWriteRawLong(longInput.toString());
        assertEquals(longInput.toString(), writer.toString());
    }

    @Test
    public void testWriteRawLong_BufferBoundary() throws Exception {
        String input = "Buffer test";
        invokeWriteRawLong(input);
        assertEquals(input, writer.toString());
    }
}
