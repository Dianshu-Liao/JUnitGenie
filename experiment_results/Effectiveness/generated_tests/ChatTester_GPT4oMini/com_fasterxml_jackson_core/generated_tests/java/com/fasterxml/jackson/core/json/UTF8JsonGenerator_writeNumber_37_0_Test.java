// Test method
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

public class UTF8JsonGenerator_writeNumber_37_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        // Assuming IOContext and ObjectCodec are properly mocked or instantiated
        IOContext ioContext = mock(IOContext.class);
        ObjectCodec objectCodec = mock(ObjectCodec.class);
        generator = new UTF8JsonGenerator(ioContext, 0, objectCodec, outputStream, '"');
    }

    @Test
    public void testWriteNumber_NullValue() throws IOException {
        generator.writeNumber((BigDecimal) null);
        assertEquals("null", outputStream.toString());
    }

    @Test
    public void testWriteNumber_AsString() throws IOException {
        setPrivateField(generator, "_cfgNumbersAsStrings", true);
        BigInteger value = new BigInteger("12345");
        generator.writeNumber(value);
        assertEquals("\"12345\"", outputStream.toString());
    }

    @Test
    public void testWriteNumber_AsRaw() throws IOException {
        setPrivateField(generator, "_cfgNumbersAsStrings", false);
        BigInteger value = new BigInteger("12345");
        generator.writeNumber(value);
        assertEquals("12345", outputStream.toString());
    }

    @Test
    public void testWriteNumber_NegativeValue() throws IOException {
        BigInteger value = new BigInteger("-12345");
        generator.writeNumber(value);
        assertEquals("-12345", outputStream.toString());
    }

    @Test
    public void testWriteNumber_ZeroValue() throws IOException {
        BigInteger value = BigInteger.ZERO;
        generator.writeNumber(value);
        assertEquals("0", outputStream.toString());
    }

    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            fail("Failed to set private field: " + fieldName);
        }
    }
}
