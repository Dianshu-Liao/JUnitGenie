package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.io.ContentReference;
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

public class UTF8JsonGenerator_writeNumber_31_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() throws IOException {
        outputStream = new ByteArrayOutputStream();
        BufferRecycler bufferRecycler = new BufferRecycler();
        IOContext ioContext = new IOContext(StreamReadConstraints.defaults(), StreamWriteConstraints.defaults(), ErrorReportConfiguration.defaults(), bufferRecycler, ContentReference.rawReference(outputStream), true);
        ObjectCodec codec = mock(ObjectCodec.class);
        generator = new UTF8JsonGenerator(ioContext, 0, codec, outputStream, '"');
    }

    @Test
    public void testWriteNumber() throws IOException {
        // Test writing a positive short value
        short value = 123;
        generator.writeNumber(value);
        generator.flush();
        String output = outputStream.toString("UTF-8");
        assertEquals("123", output.trim());
        // Reset output stream for next test
        outputStream.reset();
        // Test writing a negative short value
        value = -123;
        generator.writeNumber(value);
        generator.flush();
        output = outputStream.toString("UTF-8");
        assertEquals("-123", output.trim());
        // Reset output stream for next test
        outputStream.reset();
        // Test writing zero
        value = 0;
        generator.writeNumber(value);
        generator.flush();
        output = outputStream.toString("UTF-8");
        assertEquals("0", output.trim());
    }
}
