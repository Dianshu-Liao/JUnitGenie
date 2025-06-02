package com.fasterxml.jackson.core.json;

import java.math.BigDecimal;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.IOContext;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.NumberOutput;

class WriterBasedJsonGenerator_writeNumber_43_0_Test {

    private WriterBasedJsonGenerator jsonGenerator;

    private StringWriter writer;

    @BeforeEach
    void setUp() {
        writer = new StringWriter();
        IOContext context = mock(IOContext.class);
        ObjectCodec codec = mock(ObjectCodec.class);
        jsonGenerator = new WriterBasedJsonGenerator(context, 0, codec, writer);
    }

    @Test
    void testWriteNumber_NullValue() throws IOException {
        jsonGenerator.writeNumber((BigDecimal) null);
        assertEquals("null", writer.toString());
    }

    @Test
    void testWriteNumber_AsString() throws IOException {
        // Accessing the protected field using reflection
        setProtectedField(jsonGenerator, "_cfgNumbersAsStrings", true);
        BigDecimal value = new BigDecimal("123.45");
        jsonGenerator.writeNumber(value);
        assertEquals("\"123.45\"", writer.toString());
    }

    @Test
    void testWriteNumber_AsNumber() throws IOException {
        // Accessing the protected field using reflection
        setProtectedField(jsonGenerator, "_cfgNumbersAsStrings", false);
        BigDecimal value = new BigDecimal("123.45");
        jsonGenerator.writeNumber(value);
        assertEquals("123.45", writer.toString());
    }

    @Test
    void testWriteNumber_Zero() throws IOException {
        BigDecimal value = BigDecimal.ZERO;
        jsonGenerator.writeNumber(value);
        assertEquals("0", writer.toString());
    }

    @Test
    void testWriteNumber_Negative() throws IOException {
        BigDecimal value = new BigDecimal("-123.45");
        jsonGenerator.writeNumber(value);
        assertEquals("-123.45", writer.toString());
    }

    @Test
    void testWriteNumber_LargeValue() throws IOException {
        BigDecimal value = new BigDecimal("1234567890123456789012345678901234567890");
        jsonGenerator.writeNumber(value);
        assertEquals("1234567890123456789012345678901234567890", writer.toString());
    }

    @Test
    void testWriteNumber_SmallValue() throws IOException {
        BigDecimal value = new BigDecimal("0.0000000000000001");
        jsonGenerator.writeNumber(value);
        assertEquals("0.0000000000000001", writer.toString());
    }

    private void setProtectedField(Object obj, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
