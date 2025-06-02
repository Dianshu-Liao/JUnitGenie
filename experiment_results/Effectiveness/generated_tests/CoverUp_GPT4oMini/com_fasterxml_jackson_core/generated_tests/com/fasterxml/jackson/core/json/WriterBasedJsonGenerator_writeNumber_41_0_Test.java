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

class WriterBasedJsonGenerator_writeNumber_41_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    @BeforeEach
    void setUp() {
        writer = new StringWriter();
        IOContext ioContext = new IOContext(null, writer, false);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, writer);
    }

    @Test
    void testWriteNumber_Finite() throws Exception {
        double number = 123.456;
        generator.writeNumber(number);
        assertEquals("123.456", writer.toString());
    }

    @Test
    void testWriteNumber_NegativeFinite() throws Exception {
        double number = -123.456;
        generator.writeNumber(number);
        assertEquals("-123.456", writer.toString());
    }

    @Test
    void testWriteNumber_PositiveInfinity() throws Exception {
        double number = Double.POSITIVE_INFINITY;
        generator.writeNumber(number);
        assertEquals("Infinity", writer.toString());
    }

    @Test
    void testWriteNumber_NegativeInfinity() throws Exception {
        double number = Double.NEGATIVE_INFINITY;
        generator.writeNumber(number);
        assertEquals("-Infinity", writer.toString());
    }

    @Test
    void testWriteNumber_NaN() throws Exception {
        double number = Double.NaN;
        generator.writeNumber(number);
        assertEquals("NaN", writer.toString());
    }

    @Test
    void testWriteNumber_Zero() throws Exception {
        double number = 0.0;
        generator.writeNumber(number);
        assertEquals("0.0", writer.toString());
    }

    @Test
    void testWriteNumber_NegativeZero() throws Exception {
        double number = -0.0;
        generator.writeNumber(number);
        assertEquals("0.0", writer.toString());
    }

    @Test
    void testWriteNumber_QuotesNonNumeric() throws Exception {
        // Assuming the feature QUOTE_NON_NUMERIC_NUMBERS is enabled
        Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("writeNumber", double.class);
        method.setAccessible(true);
        // Simulate enabling QUOTE_NON_NUMERIC_NUMBERS
        boolean original = generator.isEnabled(WriterBasedJsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS);
        generator.enable(WriterBasedJsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS);
        double number = Double.NaN;
        generator.writeNumber(number);
        assertEquals("\"NaN\"", writer.toString());
        // Restore original state
        if (!original) {
            generator.disable(WriterBasedJsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS);
        }
    }
}
