package com.fasterxml.jackson.core.json;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.IOContext;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.NumberOutput;

public class UTF8JsonGenerator_writeNumber_41_0_Test {

    private ByteArrayOutputStream outputStream;

    private UTF8JsonGenerator jsonGenerator;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, true);
        jsonGenerator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteNumber_NullValue() throws IOException {
        jsonGenerator.writeNumber((String) null);
        assertEquals("null", outputStream.toString());
    }

    @Test
    public void testWriteNumber_QuotedString() throws IOException {
        jsonGenerator.writeNumber("12345");
        assertEquals("12345", outputStream.toString());
    }

    @Test
    public void testWriteNumber_RawNumber() throws IOException {
        jsonGenerator.writeNumber("67890");
        assertEquals("67890", outputStream.toString());
    }

    @Test
    public void testWriteNumber_EmptyString() throws IOException {
        jsonGenerator.writeNumber("");
        assertEquals("", outputStream.toString());
    }

    @Test
    public void testWriteNumber_NegativeNumber() throws IOException {
        jsonGenerator.writeNumber("-12345");
        assertEquals("-12345", outputStream.toString());
    }

    @Test
    public void testWriteNumber_FloatNumber() throws IOException {
        jsonGenerator.writeNumber("123.456");
        assertEquals("123.456", outputStream.toString());
    }

    @Test
    public void testWriteNumber_ScientificNotation() throws IOException {
        jsonGenerator.writeNumber("1.23e10");
        assertEquals("1.23e10", outputStream.toString());
    }

    @Test
    public void testWriteNumber_LeadingZeros() throws IOException {
        jsonGenerator.writeNumber("000123");
        assertEquals("000123", outputStream.toString());
    }

    @Test
    public void testWriteNumber_TooLargeNumber() throws IOException {
        jsonGenerator.writeNumber("12345678901234567890");
        assertEquals("12345678901234567890", outputStream.toString());
    }

    @Test
    public void testWriteNumber_NonNumericString() {
        Exception exception = assertThrows(IOException.class, () -> {
            jsonGenerator.writeNumber("notANumber");
        });
        assertTrue(exception.getMessage().contains("Invalid number format"));
    }

    @Test
    public void testWriteNumber_SpecialCharacters() throws IOException {
        jsonGenerator.writeNumber("1234@567");
        assertEquals("1234@567", outputStream.toString());
    }

    @Test
    public void testWriteNumber_EscapedCharacters() throws IOException {
        jsonGenerator.writeNumber("1234\\567");
        assertEquals("1234\\567", outputStream.toString());
    }
}
