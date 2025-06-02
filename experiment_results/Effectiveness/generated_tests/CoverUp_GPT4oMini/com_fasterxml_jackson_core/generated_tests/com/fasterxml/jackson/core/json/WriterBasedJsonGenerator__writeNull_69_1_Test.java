package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
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

public class WriterBasedJsonGenerator__writeNull_69_1_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter stringWriter;

    @BeforeEach
    public void setUp() {
        stringWriter = new StringWriter();
        IOContext ioContext = new IOContext(null, null, null, null, null, false);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, stringWriter);
    }

    @Test
    public void testWriteNull() throws Exception {
        invokePrivateWriteNull();
        String result = stringWriter.toString();
        assertEquals("null", result);
    }

    private void invokePrivateWriteNull() throws Exception {
        Method writeNullMethod = WriterBasedJsonGenerator.class.getDeclaredMethod("_writeNull");
        writeNullMethod.setAccessible(true);
        writeNullMethod.invoke(generator);
    }

    @Test
    public void testWriteNullFlushesBuffer() throws Exception {
        // Fill the buffer to force a flush
        for (int i = 0; i < 32; i++) {
            // Fill with dummy data
            generator._outputBuffer[i] = 'a';
        }
        generator._outputTail = 32;
        generator._outputEnd = 32;
        invokePrivateWriteNull();
        String result = stringWriter.toString();
        assertEquals("null", result);
    }
}
