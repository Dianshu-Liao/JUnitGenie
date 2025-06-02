package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
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

public class UTF8JsonGenerator_writeNumber_35_0_Test {

    private ByteArrayOutputStream outputStream;

    private UTF8JsonGenerator jsonGenerator;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, true);
        jsonGenerator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteNumberPositiveLong() throws IOException {
        jsonGenerator.writeNumber(123456789L);
        jsonGenerator.flush();
        assertEquals("123456789", outputStream.toString("UTF-8"));
    }

    @Test
    public void testWriteNumberNegativeLong() throws IOException {
        jsonGenerator.writeNumber(-987654321L);
        jsonGenerator.flush();
        assertEquals("-987654321", outputStream.toString("UTF-8"));
    }

    @Test
    public void testWriteNumberZero() throws IOException {
        jsonGenerator.writeNumber(0L);
        jsonGenerator.flush();
        assertEquals("0", outputStream.toString("UTF-8"));
    }

    @Test
    public void testWriteNumberMaxLong() throws IOException {
        jsonGenerator.writeNumber(Long.MAX_VALUE);
        jsonGenerator.flush();
        assertEquals("9223372036854775807", outputStream.toString("UTF-8"));
    }

    @Test
    public void testWriteNumberMinLong() throws IOException {
        jsonGenerator.writeNumber(Long.MIN_VALUE);
        jsonGenerator.flush();
        assertEquals("-9223372036854775808", outputStream.toString("UTF-8"));
    }

    @Test
    public void testWriteNumberAsString() throws IOException {
        // Simulating the behavior of writing numbers as strings
        jsonGenerator.writeNumber(123456789L);
        jsonGenerator.flush();
        // Expecting the number without quotes
        assertEquals("123456789", outputStream.toString("UTF-8"));
    }

    @Test
    public void testWriteNumberBufferFlush() throws IOException {
        // Fill the buffer to force a flush
        for (long i = 1; i <= 1000000000L; i *= 10) {
            jsonGenerator.writeNumber(i);
        }
        jsonGenerator.flush();
        String output = outputStream.toString("UTF-8");
        assertEquals("1\n10\n100\n1000\n10000\n100000\n1000000\n10000000\n100000000\n1000000000", output.trim());
    }
}
