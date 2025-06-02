package com.fasterxml.jackson.core.json;

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
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;

public class WriterBasedJsonGenerator_writeRaw_28_0_Test {

    private WriterBasedJsonGenerator generator;

    @Mock
    private IOContext ioContext;

    @Mock
    private ObjectCodec objectCodec;

    @Mock
    private SerializableString serializableString;

    private StringWriter stringWriter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        stringWriter = new StringWriter();
        generator = new WriterBasedJsonGenerator(ioContext, 0, objectCodec, stringWriter);
        // Initialize the output buffer
        generator._outputBuffer = new char[64];
        // Initialize the output tail
        generator._outputTail = 0;
    }

    @Test
    public void testWriteRaw_AppendsSuccessfully() throws IOException {
        // Arrange
        when(serializableString.appendUnquoted(any(char[].class), anyInt())).thenReturn(5);
        when(serializableString.getValue()).thenReturn("Test");
        // Act
        generator.writeRaw(serializableString);
        // Assert
        assertEquals(5, generator._outputTail);
        assertEquals("Test", stringWriter.toString());
    }

    @Test
    public void testWriteRaw_CallsWriteRawWithValue() throws IOException {
        // Arrange
        when(serializableString.appendUnquoted(any(char[].class), anyInt())).thenReturn(-1);
        when(serializableString.getValue()).thenReturn("Fallback");
        // Act
        generator.writeRaw(serializableString);
        // Assert
        assertEquals(0, generator._outputTail);
        assertEquals("Fallback", stringWriter.toString());
    }

    @Test
    public void testWriteRaw_HandlesIOException() {
        // Arrange
        when(serializableString.appendUnquoted(any(char[].class), anyInt())).thenThrow(new IOException("Test Exception"));
        // Act & Assert
        assertThrows(IOException.class, () -> {
            generator.writeRaw(serializableString);
        });
    }
}
