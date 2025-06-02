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

public class WriterBasedJsonGenerator_writeNumber_34_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter stringWriter;

    @BeforeEach
    public void setUp() {
        // Initialize the StringWriter and the WriterBasedJsonGenerator
        stringWriter = new StringWriter();
        IOContext ioContext = new IOContext(null, null, null, null, null, false);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, stringWriter);
    }

    @Test
    public void testWriteNumberPositiveShort() throws Exception {
        short value = 12345;
        invokeWriteNumber(value);
        assertEquals("12345", stringWriter.toString());
    }

    @Test
    public void testWriteNumberNegativeShort() throws Exception {
        short value = -12345;
        invokeWriteNumber(value);
        assertEquals("-12345", stringWriter.toString());
    }

    @Test
    public void testWriteNumberZero() throws Exception {
        short value = 0;
        invokeWriteNumber(value);
        assertEquals("0", stringWriter.toString());
    }

    @Test
    public void testWriteNumberAsString() throws Exception {
        // Set the configuration to write numbers as strings
        setConfigNumbersAsStrings(true);
        short value = 12345;
        invokeWriteNumber(value);
        assertEquals("\"12345\"", stringWriter.toString());
    }

    private void invokeWriteNumber(short value) throws Exception {
        Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("writeNumber", short.class);
        method.setAccessible(true);
        method.invoke(generator, value);
    }

    private void setConfigNumbersAsStrings(boolean value) throws Exception {
        // Use reflection to set the _cfgNumbersAsStrings field
        java.lang.reflect.Field field = WriterBasedJsonGenerator.class.getDeclaredField("_cfgNumbersAsStrings");
        field.setAccessible(true);
        field.set(generator, value);
    }
}
