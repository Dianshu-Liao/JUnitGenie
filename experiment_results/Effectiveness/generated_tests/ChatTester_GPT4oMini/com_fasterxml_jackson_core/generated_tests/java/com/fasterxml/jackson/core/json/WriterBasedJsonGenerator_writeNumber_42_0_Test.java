package com.fasterxml.jackson.core.json;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.IOContext;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.NumberOutput;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;

public class WriterBasedJsonGenerator_writeNumber_42_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    @BeforeEach
    public void setUp() {
        writer = new StringWriter();
        generator = new WriterBasedJsonGenerator(mock(IOContext.class), 0, mock(ObjectCodec.class), writer);
    }

    @Test
    public void testWriteNumber_NumbersAsStringsEnabled() throws IOException {
        setPrivateField(generator, "_cfgNumbersAsStrings", true);
        generator.writeNumber(123.45f);
        assertEquals("\"123.45\"", writer.toString());
    }

    @Test
    public void testWriteNumber_NonFiniteWithQuotingEnabled() throws IOException {
        setPrivateField(generator, "_cfgNumbersAsStrings", false);
        setPrivateField(generator, "_quoteChar", '"');
        when(generator.isEnabled(WriterBasedJsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS)).thenReturn(true);
        generator.writeNumber(Float.NaN);
        assertEquals("\"NaN\"", writer.toString());
    }

    @Test
    public void testWriteNumber_FiniteNumber() throws IOException {
        setPrivateField(generator, "_cfgNumbersAsStrings", false);
        when(generator.isEnabled(WriterBasedJsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS)).thenReturn(false);
        generator.writeNumber(123.45f);
        assertEquals("123.45", writer.toString());
    }

    @Test
    public void testWriteNumber_NonFiniteWithoutQuoting() throws IOException {
        setPrivateField(generator, "_cfgNumbersAsStrings", false);
        when(generator.isEnabled(WriterBasedJsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS)).thenReturn(false);
        generator.writeNumber(Float.NaN);
        assertEquals("", writer.toString());
    }

    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            // Repaired line
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }
}
