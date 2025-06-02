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

class WriterBasedJsonGenerator__writeFieldNameTail_8_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    private IOContext ioContext;

    private SerializableString serializableString;

    @BeforeEach
    void setUp() {
        writer = new StringWriter();
        ioContext = mock(IOContext.class);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, writer, '"');
        serializableString = mock(SerializableString.class);
    }

    @Test
    void testWriteFieldNameTail() throws IOException {
        // Arrange
        char[] quotedChars = { '\"', 't', 'e', 's', 't', '\"' };
        when(serializableString.asQuotedChars()).thenReturn(quotedChars);
        // Act
        generator._writeFieldNameTail(serializableString);
        // Assert
        String result = writer.toString();
        String expected = "\"test\"";
        assert (result.equals(expected));
    }

    @Test
    void testWriteFieldNameTailBufferFlush() throws IOException {
        // Arrange
        char[] quotedChars = new char[WriterBasedJsonGenerator.SHORT_WRITE + 1];
        for (int i = 0; i < quotedChars.length; i++) {
            // Fill with 'a's
            quotedChars[i] = 'a';
        }
        when(serializableString.asQuotedChars()).thenReturn(quotedChars);
        // Act
        generator._writeFieldNameTail(serializableString);
        // Assert
        String result = writer.toString();
        assert (result.length() > WriterBasedJsonGenerator.SHORT_WRITE);
    }

    @Test
    void testWriteFieldNameTailHandlesIOException() {
        // Arrange
        char[] quotedChars = { '\"', 'e', 'x', 'c', 'e', 'p', 't', 'i', 'o', 'n', '\"' };
        when(serializableString.asQuotedChars()).thenReturn(quotedChars);
        doThrow(new IOException("Writer error")).when(ioContext).getEncoding();
        // Act & Assert
        try {
            generator._writeFieldNameTail(serializableString);
        } catch (IOException e) {
            assert (e.getMessage().equals("Writer error"));
        }
    }
}
