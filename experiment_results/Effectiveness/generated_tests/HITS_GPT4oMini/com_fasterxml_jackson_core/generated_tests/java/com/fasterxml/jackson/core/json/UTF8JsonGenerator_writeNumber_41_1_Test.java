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

public class UTF8JsonGenerator_writeNumber_41_1_Test {

    private TestUTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    private IOContext ioContext;

    private static class TestUTF8JsonGenerator extends UTF8JsonGenerator {

        protected boolean _cfgNumbersAsStrings;

        public TestUTF8JsonGenerator(IOContext ctxt, int features, ObjectCodec codec, OutputStream out, char quoteChar) {
            super(ctxt, features, codec, out, quoteChar);
        }

        public void setNumbersAsStrings(boolean value) {
            this._cfgNumbersAsStrings = value;
        }
    }

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        BufferRecycler bufferRecycler = new BufferRecycler();
        ioContext = new IOContext(bufferRecycler, null, true);
        generator = new TestUTF8JsonGenerator(ioContext, 0, Mockito.mock(ObjectCodec.class), outputStream, '"');
    }

    @Test
    public void testWriteNumber_NullValue() throws IOException {
        generator.writeNumber((String) null);
        String result = outputStream.toString("UTF-8");
        assertEquals("null", result);
    }

    @Test
    public void testWriteNumber_QuotedString() throws IOException {
        generator.setNumbersAsStrings(true);
        String number = "12345";
        generator.writeNumber(number);
        String result = outputStream.toString("UTF-8");
        assertEquals("\"12345\"", result);
    }

    @Test
    public void testWriteNumber_RawString() throws IOException {
        generator.setNumbersAsStrings(false);
        String number = "12345";
        generator.writeNumber(number);
        String result = outputStream.toString("UTF-8");
        assertEquals("12345", result);
    }

    @Test
    public void testWriteNumber_EmptyString() throws IOException {
        generator.writeNumber("");
        String result = outputStream.toString("UTF-8");
        assertEquals("", result);
    }

    @Test
    public void testWriteNumber_NegativeNumber() throws IOException {
        String number = "-12345";
        generator.writeNumber(number);
        String result = outputStream.toString("UTF-8");
        assertEquals("-12345", result);
    }

    @Test
    public void testWriteNumber_FloatNumber() throws IOException {
        String number = "123.45";
        generator.writeNumber(number);
        String result = outputStream.toString("UTF-8");
        assertEquals("123.45", result);
    }
}
