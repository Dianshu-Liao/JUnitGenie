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

class WriterBasedJsonGenerator_writeNumber_41_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    @BeforeEach
    void setUp() {
        writer = new StringWriter();
        // Creating a mock IOContext since the constructor requires parameters
        IOContext ioContext = mock(IOContext.class);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, writer);
    }

    @Test
    void testWriteNumber_ValidDouble() throws IOException {
        double value = 123.45;
        generator.writeNumber(value);
        assertEquals("123.45", writer.toString());
    }

    @Test
    void testWriteNumber_NegativeDouble() throws IOException {
        double value = -123.45;
        generator.writeNumber(value);
        assertEquals("-123.45", writer.toString());
    }

    @Test
    void testWriteNumber_NonFiniteDouble() throws IOException {
        double value = Double.NaN;
        generator.writeNumber(value);
        assertTrue(writer.toString().contains("NaN"));
    }

    @Test
    void testWriteNumber_Infinity() throws IOException {
        double value = Double.POSITIVE_INFINITY;
        generator.writeNumber(value);
        assertTrue(writer.toString().contains("Infinity"));
    }

    @Test
    void testWriteNumber_NegativeInfinity() throws IOException {
        double value = Double.NEGATIVE_INFINITY;
        generator.writeNumber(value);
        assertTrue(writer.toString().contains("-Infinity"));
    }

    @Test
    void testWriteNumber_QuoteNonNumericEnabled() throws Exception {
        setField(generator, "_cfgNumbersAsStrings", true);
        double value = Double.NaN;
        generator.writeNumber(value);
        assertEquals("\"NaN\"", writer.toString());
    }

    @Test
    void testWriteNumber_UseFastDoubleWriter() throws Exception {
        setField(generator, "_cfgNumbersAsStrings", false);
        double value = 123.456;
        generator.writeNumber(value);
        assertEquals("123.456", writer.toString());
    }

    @Test
    void testWriteNumber_Zero() throws IOException {
        double value = 0.0;
        generator.writeNumber(value);
        assertEquals("0.0", writer.toString());
    }

    @Test
    void testWriteNumber_QuoteEnabled() throws Exception {
        setField(generator, "_cfgNumbersAsStrings", true);
        double value = Double.POSITIVE_INFINITY;
        generator.writeNumber(value);
        assertEquals("\"Infinity\"", writer.toString());
    }

    private void setField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private Object invokePrivateMethod(String methodName, Object... args) throws Exception {
        java.lang.reflect.Method method = WriterBasedJsonGenerator.class.getDeclaredMethod(methodName, double.class);
        method.setAccessible(true);
        return method.invoke(generator, args);
    }
}
