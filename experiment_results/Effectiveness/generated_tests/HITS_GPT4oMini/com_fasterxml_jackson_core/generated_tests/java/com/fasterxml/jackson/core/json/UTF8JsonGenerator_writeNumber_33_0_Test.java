package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
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

public class UTF8JsonGenerator_writeNumber_33_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(new BufferRecycler(), outputStream, true);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteNumber_PositiveSingleDigit() throws IOException {
        generator.writeNumber(5);
        generator.flush();
        byte[] expected = new byte[] { '5' };
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteNumber_NegativeSingleDigit() throws IOException {
        generator.writeNumber(-3);
        generator.flush();
        byte[] expected = new byte[] { '-', '3' };
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteNumber_PositiveMultipleDigits() throws IOException {
        generator.writeNumber(123);
        generator.flush();
        byte[] expected = new byte[] { '1', '2', '3' };
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteNumber_NegativeMultipleDigits() throws IOException {
        generator.writeNumber(-456);
        generator.flush();
        byte[] expected = new byte[] { '-', '4', '5', '6' };
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteNumber_LargePositiveNumber() throws IOException {
        generator.writeNumber(987654321);
        generator.flush();
        byte[] expected = new byte[] { '9', '8', '7', '6', '5', '4', '3', '2', '1' };
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteNumber_LargeNegativeNumber() throws IOException {
        generator.writeNumber(-987654321);
        generator.flush();
        byte[] expected = new byte[] { '-', '9', '8', '7', '6', '5', '4', '3', '2', '1' };
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteNumber_Zero() throws IOException {
        generator.writeNumber(0);
        generator.flush();
        byte[] expected = new byte[] { '0' };
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteNumber_Overflow() throws IOException {
        // Testing the Integer.MIN_VALUE case
        generator.writeNumber(Integer.MIN_VALUE);
        generator.flush();
        byte[] expected = new byte[] { '-', '2', '1', '4', '7', '4', '8', '3', '6', '4', '8' };
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteNumber_Underflow() throws IOException {
        // Testing the Integer.MAX_VALUE case
        generator.writeNumber(Integer.MAX_VALUE);
        generator.flush();
        byte[] expected = new byte[] { '2', '1', '4', '7', '4', '8', '3', '6', '4', '7' };
        assertArrayEquals(expected, outputStream.toByteArray());
    }
}
