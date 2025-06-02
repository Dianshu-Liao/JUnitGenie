package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.util.BufferRecycler;
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

public class UTF8JsonGenerator_writeNumber_38_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(new BufferRecycler(), null, true);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteNumber_ValidDouble() throws IOException {
        double value = 123.456;
        generator.writeNumber(value);
        generator.close();
        String expectedOutput = "123.456";
        String actualOutput = outputStream.toString("UTF-8");
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testWriteNumber_NegativeDouble() throws IOException {
        double value = -789.123;
        generator.writeNumber(value);
        generator.close();
        String expectedOutput = "-789.123";
        String actualOutput = outputStream.toString("UTF-8");
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testWriteNumber_NonFinite() throws IOException {
        double value = Double.NaN;
        generator.writeNumber(value);
        generator.close();
        // Assuming the behavior for non-finite numbers is to output as string
        String expectedOutput = "NaN";
        String actualOutput = outputStream.toString("UTF-8");
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testWriteNumber_Infinity() throws IOException {
        double value = Double.POSITIVE_INFINITY;
        generator.writeNumber(value);
        generator.close();
        // Assuming the behavior for positive infinity
        String expectedOutput = "Infinity";
        String actualOutput = outputStream.toString("UTF-8");
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testWriteNumber_NegativeInfinity() throws IOException {
        double value = Double.NEGATIVE_INFINITY;
        generator.writeNumber(value);
        generator.close();
        // Assuming the behavior for negative infinity
        String expectedOutput = "-Infinity";
        String actualOutput = outputStream.toString("UTF-8");
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testWriteNumber_Zero() throws IOException {
        double value = 0.0;
        generator.writeNumber(value);
        generator.close();
        String expectedOutput = "0.0";
        String actualOutput = outputStream.toString("UTF-8");
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testWriteNumber_NegativeZero() throws IOException {
        double value = -0.0;
        generator.writeNumber(value);
        generator.close();
        String expectedOutput = "-0.0";
        String actualOutput = outputStream.toString("UTF-8");
        assertEquals(expectedOutput, actualOutput);
    }
}
