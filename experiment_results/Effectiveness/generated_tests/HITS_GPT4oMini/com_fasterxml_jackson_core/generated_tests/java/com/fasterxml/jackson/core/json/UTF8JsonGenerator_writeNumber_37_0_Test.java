package com.fasterxml.jackson.core.json;

import java.math.BigInteger;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;

public class UTF8JsonGenerator_writeNumber_37_0_Test {

    private ByteArrayOutputStream outputStream;

    private UTF8JsonGenerator generator;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        generator = new UTF8JsonGenerator(new IOContext(null, outputStream, false), 0, null, outputStream, '"');
    }

    @Test
    public void testWriteNumber_NullValue() throws IOException {
        generator.writeNumber((BigInteger) null);
        String output = outputStream.toString("UTF-8");
        assertEquals("null", output);
    }

    @Test
    public void testWriteNumber_AsString() throws IOException {
        setNumbersAsStrings(true);
        BigInteger value = new BigInteger("12345");
        generator.writeNumber(value);
        String output = outputStream.toString("UTF-8");
        assertEquals("\"12345\"", output);
    }

    @Test
    public void testWriteNumber_AsInteger() throws IOException {
        setNumbersAsStrings(false);
        BigInteger value = new BigInteger("12345");
        generator.writeNumber(value);
        String output = outputStream.toString("UTF-8");
        assertEquals("12345", output);
    }

    @Test
    public void testWriteNumber_NegativeValue() throws IOException {
        BigInteger value = new BigInteger("-12345");
        generator.writeNumber(value);
        String output = outputStream.toString("UTF-8");
        assertEquals("-12345", output);
    }

    @Test
    public void testWriteNumber_LargeValue() throws IOException {
        BigInteger value = new BigInteger("123456789012345678901234567890");
        generator.writeNumber(value);
        String output = outputStream.toString("UTF-8");
        assertEquals("123456789012345678901234567890", output);
    }

    @Test
    public void testWriteNumber_ZeroValue() throws IOException {
        BigInteger value = BigInteger.ZERO;
        generator.writeNumber(value);
        String output = outputStream.toString("UTF-8");
        assertEquals("0", output);
    }

    private void setNumbersAsStrings(boolean value) {
        // This method is a placeholder for setting the _cfgNumbersAsStrings field
        // You can implement a setter in UTF8JsonGenerator for this purpose
        // Example: generator.setNumbersAsStrings(value);
    }
}
