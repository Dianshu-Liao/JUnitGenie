package com.fasterxml.jackson.core.json;

import java.math.BigInteger;
import com.fasterxml.jackson.core.io.IOContext;
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
import com.fasterxml.jackson.core.io.NumberOutput;

class UTF8JsonGenerator_writeNumber_37_1_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    private IOContext ioContext;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        ioContext = new IOContext(null, null, true);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"') {

            // Expose the protected member for testing
            @Override
            public void writeNumber(BigInteger value) throws IOException {
                super.writeNumber(value);
            }
        };
    }

    @Test
    void testWriteNumber_NullValue() throws IOException {
        generator.writeNumber((BigInteger) null);
        assertEquals("null", outputStream.toString());
    }

    @Test
    void testWriteNumber_AsString() throws IOException {
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"') {

            @Override
            public void writeNumber(BigInteger value) throws IOException {
                this._cfgNumbersAsStrings = true;
                super.writeNumber(value);
            }
        };
        BigInteger value = new BigInteger("123456789");
        generator.writeNumber(value);
        assertEquals("\"123456789\"", outputStream.toString());
    }

    @Test
    void testWriteNumber_AsRaw() throws IOException {
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"') {

            @Override
            public void writeNumber(BigInteger value) throws IOException {
                this._cfgNumbersAsStrings = false;
                super.writeNumber(value);
            }
        };
        BigInteger value = new BigInteger("123456789");
        generator.writeNumber(value);
        assertEquals("123456789", outputStream.toString());
    }

    @Test
    void testWriteNumber_NegativeValue() throws IOException {
        BigInteger value = new BigInteger("-987654321");
        generator.writeNumber(value);
        assertEquals("-987654321", outputStream.toString());
    }

    @Test
    void testWriteNumber_ZeroValue() throws IOException {
        BigInteger value = BigInteger.ZERO;
        generator.writeNumber(value);
        assertEquals("0", outputStream.toString());
    }

    @Test
    void testWriteNumber_LargeValue() throws IOException {
        BigInteger value = new BigInteger("123456789012345678901234567890");
        generator.writeNumber(value);
        assertEquals("123456789012345678901234567890", outputStream.toString());
    }
}
