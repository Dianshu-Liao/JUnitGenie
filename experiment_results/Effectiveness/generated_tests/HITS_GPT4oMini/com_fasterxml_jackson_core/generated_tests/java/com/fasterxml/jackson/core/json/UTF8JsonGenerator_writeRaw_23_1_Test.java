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

public class UTF8JsonGenerator_writeRaw_23_1_Test {

    private ByteArrayOutputStream outputStream;

    private IOContext ioContext;

    private UTF8JsonGenerator utf8JsonGenerator;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        BufferRecycler bufferRecycler = new BufferRecycler();
        ioContext = new IOContext(bufferRecycler, outputStream, true);
        utf8JsonGenerator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteRawWithValidSerializableString() throws IOException {
        SerializableString serializableString = mock(SerializableString.class);
        byte[] rawBytes = "Hello".getBytes();
        when(serializableString.appendUnquotedUTF8(utf8JsonGenerator._outputBuffer, utf8JsonGenerator._outputTail)).thenReturn(rawBytes.length);
        when(serializableString.asUnquotedUTF8()).thenReturn(rawBytes);
        utf8JsonGenerator.writeRaw(serializableString);
        assertArrayEquals("Hello".getBytes(), outputStream.toByteArray());
    }

    @Test
    public void testWriteRawWithNegativeLength() throws IOException {
        SerializableString serializableString = mock(SerializableString.class);
        when(serializableString.appendUnquotedUTF8(utf8JsonGenerator._outputBuffer, utf8JsonGenerator._outputTail)).thenReturn(-1);
        byte[] rawBytes = "World".getBytes();
        when(serializableString.asUnquotedUTF8()).thenReturn(rawBytes);
        utf8JsonGenerator.writeRaw(serializableString);
        assertArrayEquals("World".getBytes(), outputStream.toByteArray());
    }

    @Test
    public void testWriteRawBufferOverflow() throws IOException {
        // Simulate a buffer overflow scenario
        // Set tail to end of buffer
        utf8JsonGenerator._outputTail = utf8JsonGenerator._outputEnd;
        SerializableString serializableString = mock(SerializableString.class);
        byte[] rawBytes = "Test".getBytes();
        // Pretend it fits
        when(serializableString.appendUnquotedUTF8(utf8JsonGenerator._outputBuffer, utf8JsonGenerator._outputTail)).thenReturn(4);
        when(serializableString.asUnquotedUTF8()).thenReturn(rawBytes);
        utf8JsonGenerator.writeRaw(serializableString);
        assertArrayEquals("Test".getBytes(), outputStream.toByteArray());
    }
}
