package com.fasterxml.jackson.core.json;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;

public class WriterBasedJsonGenerator__writeQuotedInt_37_0_Test {

    private WriterBasedJsonGenerator jsonGenerator;

    private StringWriter writer;

    private char quoteChar = '"';

    private char[] outputBuffer;

    // Assume a buffer size for testing
    private int outputEnd = 64;

    @BeforeEach
    public void setUp() {
        writer = new StringWriter();
        jsonGenerator = new WriterBasedJsonGenerator(Mockito.mock(IOContext.class), 0, Mockito.mock(ObjectCodec.class), writer, quoteChar);
        jsonGenerator._outputBuffer = new char[outputEnd];
        jsonGenerator._outputTail = 0;
        jsonGenerator._outputEnd = outputEnd;
        jsonGenerator._quoteChar = quoteChar;
    }

    @Test
    public void testWriteQuotedInt() throws Exception {
        // Invoke the private method using reflection
        invokePrivateWriteQuotedInt(123);
        String expectedOutput = "\"" + 123 + "\"";
        assertEquals(expectedOutput, writer.toString());
    }

    @Test
    public void testWriteQuotedIntFlushBuffer() throws Exception {
        // Fill the buffer to force a flush
        // Leave space for the flush
        jsonGenerator._outputTail = outputEnd - 10;
        invokePrivateWriteQuotedInt(456);
        String expectedOutput = "\"" + 456 + "\"";
        assertEquals(expectedOutput, writer.toString());
    }

    private void invokePrivateWriteQuotedInt(int value) throws Exception {
        // Fixed the buggy line by replacing 'var' with 'java.lang.reflect.Method'
        java.lang.reflect.Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("_writeQuotedInt", int.class);
        method.setAccessible(true);
        method.invoke(jsonGenerator, value);
    }
}
