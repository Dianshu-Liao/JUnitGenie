package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
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

public class WriterBasedJsonGenerator_writeRaw_26_2_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        writer = new StringWriter();
        BufferRecycler bufferRecycler = new BufferRecycler();
        ioContext = new IOContext(null, bufferRecycler, true);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, writer);
    }

    @Test
    public void testWriteRaw_SingleWrite() throws Exception {
        String input = "Hello";
        invokeWriteRaw(input);
        assertEquals("Hello", writer.toString());
    }

    @Test
    public void testWriteRaw_FlushBuffer() throws Exception {
        generator._outputBuffer = new char[5];
        generator._outputEnd = generator._outputBuffer.length;
        generator._outputTail = 0;
        String input = "HelloWorld";
        invokeWriteRaw(input);
        assertEquals("HelloWorld", writer.toString());
    }

    @Test
    public void testWriteRaw_ExactBufferSize() throws Exception {
        generator._outputBuffer = new char[5];
        generator._outputEnd = generator._outputBuffer.length;
        generator._outputTail = 0;
        String input = "Hello";
        invokeWriteRaw(input);
        assertEquals("Hello", writer.toString());
    }

    @Test
    public void testWriteRaw_EmptyString() throws Exception {
        invokeWriteRaw("");
        assertEquals("", writer.toString());
    }

    @Test
    public void testWriteRaw_NullInput() {
        assertThrows(NullPointerException.class, () -> {
            invokeWriteRaw(null);
        });
    }

    private void invokeWriteRaw(String input) throws Exception {
        Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("writeRaw", String.class);
        method.setAccessible(true);
        method.invoke(generator, input);
    }
}
