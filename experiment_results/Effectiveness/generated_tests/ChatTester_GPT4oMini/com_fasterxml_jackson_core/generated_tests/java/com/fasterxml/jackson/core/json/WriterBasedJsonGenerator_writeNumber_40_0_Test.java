package com.fasterxml.jackson.core.json;

import java.math.BigInteger;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
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

public class WriterBasedJsonGenerator_writeNumber_40_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    @BeforeEach
    public void setUp() {
        writer = new StringWriter();
        // Assuming IOContext and ObjectCodec are mocked or initialized as needed
        IOContext ioContext = mock(IOContext.class);
        ObjectCodec codec = mock(ObjectCodec.class);
        generator = new WriterBasedJsonGenerator(ioContext, 0, codec, writer);
    }

    @Test
    public void testWriteNumber_NullValue() throws IOException {
        generator.writeNumber((BigDecimal) null);
        assertEquals("null", writer.toString());
    }

    @Test
    public void testWriteNumber_AsString() throws IOException {
        setPrivateField(generator, "_cfgNumbersAsStrings", true);
        generator.writeNumber(BigInteger.valueOf(123));
        assertEquals("\"123\"", writer.toString());
    }

    @Test
    public void testWriteNumber_AsRaw() throws IOException {
        setPrivateField(generator, "_cfgNumbersAsStrings", false);
        generator.writeNumber(BigInteger.valueOf(123));
        assertEquals("123", writer.toString());
    }

    @Test
    public void testWriteNumber_BigIntegerNegative() throws IOException {
        generator.writeNumber(BigInteger.valueOf(-456));
        assertEquals("-456", writer.toString());
    }

    @Test
    public void testWriteNumber_BigIntegerZero() throws IOException {
        generator.writeNumber(BigInteger.ZERO);
        assertEquals("0", writer.toString());
    }

    @Test
    public void testWriteNumber_BigIntegerLargeValue() throws IOException {
        BigInteger largeValue = new BigInteger("123456789012345678901234567890");
        generator.writeNumber(largeValue);
        assertEquals("123456789012345678901234567890", writer.toString());
    }

    private void setPrivateField(Object target, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }
}
