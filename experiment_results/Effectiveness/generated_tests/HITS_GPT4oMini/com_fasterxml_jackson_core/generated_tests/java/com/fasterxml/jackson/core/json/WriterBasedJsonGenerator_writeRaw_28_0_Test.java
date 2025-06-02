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

class WriterBasedJsonGenerator_writeRaw_28_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter stringWriter;

    private IOContext ioContext;

    @BeforeEach
    void setUp() {
        stringWriter = new StringWriter();
        ioContext = new IOContext(new BufferRecycler(), stringWriter, true);
        // Use the non-deprecated constructor
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, stringWriter, '"');
    }

    @Test
    void testWriteRaw_WithValidSerializableString() throws IOException {
        SerializableString serializableString = mock(SerializableString.class);
        when(serializableString.getValue()).thenReturn("Test String");
        when(serializableString.appendUnquoted(any(char[].class), any(Integer.class))).thenAnswer(invocation -> {
            char[] outputBuffer = invocation.getArgument(0);
            int tail = invocation.getArgument(1);
            System.arraycopy("Test String".toCharArray(), 0, outputBuffer, tail, "Test String".length());
            return "Test String".length();
        });
        // Call the method with a SerializableString
        generator.writeRaw(serializableString);
        assertEquals("Test String", stringWriter.toString());
    }

    @Test
    void testWriteRaw_WithNegativeLength() throws IOException {
        SerializableString serializableString = mock(SerializableString.class);
        when(serializableString.getValue()).thenReturn("Another Test");
        when(serializableString.appendUnquoted(any(char[].class), any(Integer.class))).thenReturn(-1);
        // Call the method with a SerializableString
        generator.writeRaw(serializableString);
        assertEquals("Another Test", stringWriter.toString());
    }

    @Test
    void testWriteRaw_WithEmptySerializableString() throws IOException {
        SerializableString serializableString = mock(SerializableString.class);
        when(serializableString.getValue()).thenReturn("");
        when(serializableString.appendUnquoted(any(char[].class), any(Integer.class))).thenReturn(0);
        // Call the method with a SerializableString
        generator.writeRaw(serializableString);
        assertEquals("", stringWriter.toString());
    }
}
