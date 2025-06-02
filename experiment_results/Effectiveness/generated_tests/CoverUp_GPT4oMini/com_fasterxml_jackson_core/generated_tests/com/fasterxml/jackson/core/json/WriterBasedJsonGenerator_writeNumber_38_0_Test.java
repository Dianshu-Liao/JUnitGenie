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

public class WriterBasedJsonGenerator_writeNumber_38_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter stringWriter;

    @BeforeEach
    public void setUp() {
        stringWriter = new StringWriter();
        IOContext ioContext = new IOContext(null, null, null, null, null, false);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, stringWriter);
    }

    @Test
    public void testWriteNumber() throws Exception {
        // Test writing a positive number
        invokeWriteNumber(123456789L);
        assertEquals("123456789", stringWriter.toString());
        // Clear the writer for the next test
        stringWriter.getBuffer().setLength(0);
        // Test writing a negative number
        invokeWriteNumber(-987654321L);
        assertEquals("-987654321", stringWriter.toString());
        // Clear the writer for the next test
        stringWriter.getBuffer().setLength(0);
        // Test writing zero
        invokeWriteNumber(0L);
        assertEquals("0", stringWriter.toString());
        // Clear the writer for the next test
        stringWriter.getBuffer().setLength(0);
        // Test writing Long.MIN_VALUE
        invokeWriteNumber(Long.MIN_VALUE);
        assertEquals("-9223372036854775808", stringWriter.toString());
        // Clear the writer for the next test
        stringWriter.getBuffer().setLength(0);
        // Test writing Long.MAX_VALUE
        invokeWriteNumber(Long.MAX_VALUE);
        assertEquals("9223372036854775807", stringWriter.toString());
    }

    private void invokeWriteNumber(long number) throws Exception {
        Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("writeNumber", long.class);
        method.setAccessible(true);
        method.invoke(generator, number);
    }
}
