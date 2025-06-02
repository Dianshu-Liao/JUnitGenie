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

public class WriterBasedJsonGenerator_writeNumber_44_0_Test {

    private WriterBasedJsonGenerator jsonGenerator;

    private StringWriter stringWriter;

    @BeforeEach
    public void setUp() {
        stringWriter = new StringWriter();
        IOContext ioContext = mock(IOContext.class);
        ObjectCodec objectCodec = mock(ObjectCodec.class);
        jsonGenerator = new WriterBasedJsonGenerator(ioContext, 0, objectCodec, stringWriter);
    }

    @Test
    public void testWriteNumber_NullValue() throws IOException {
        jsonGenerator.writeNumber((BigDecimal) null);
        assertEquals("null", stringWriter.toString());
    }

    @Test
    public void testWriteNumber_AsString() throws IOException {
        setPrivateField(jsonGenerator, "_cfgNumbersAsStrings", true);
        jsonGenerator.writeNumber("123");
        assertEquals("\"123\"", stringWriter.toString());
    }

    @Test
    public void testWriteNumber_NotAsString() throws IOException {
        setPrivateField(jsonGenerator, "_cfgNumbersAsStrings", false);
        jsonGenerator.writeNumber("123");
        assertEquals("123", stringWriter.toString());
    }

    @Test
    public void testWriteNumber_EmptyString() throws IOException {
        jsonGenerator.writeNumber("");
        assertEquals("", stringWriter.toString());
    }

    @Test
    public void testWriteNumber_NegativeNumber() throws IOException {
        jsonGenerator.writeNumber("-123");
        assertEquals("-123", stringWriter.toString());
    }

    @Test
    public void testWriteNumber_FloatNumber() throws IOException {
        jsonGenerator.writeNumber("123.45");
        assertEquals("123.45", stringWriter.toString());
    }

    @Test
    public void testWriteNumber_LeadingZeros() throws IOException {
        jsonGenerator.writeNumber("00123");
        assertEquals("00123", stringWriter.toString());
    }

    // Utility method to set private fields using reflection
    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }
}
