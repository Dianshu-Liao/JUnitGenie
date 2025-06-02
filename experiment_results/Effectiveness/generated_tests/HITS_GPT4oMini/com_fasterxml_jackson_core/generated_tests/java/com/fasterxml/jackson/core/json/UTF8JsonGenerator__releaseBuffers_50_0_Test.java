package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

public class UTF8JsonGenerator__releaseBuffers_50_0_Test {

    private UTF8JsonGenerator generator;

    private IOContext ioContext;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        ioContext = new IOContext(null, outputStream, true);
        // Create a mock ObjectCodec
        ObjectCodec codec = mock(ObjectCodec.class);
        // Example quote character
        char quoteChar = '"';
        generator = new UTF8JsonGenerator(ioContext, 0, codec, outputStream, quoteChar);
    }

    @Test
    public void testReleaseBuffers_WhenBuffersAreRecyclable() {
        // Arrange
        generator._outputBuffer = new byte[512];
        generator._charBuffer = new char[512];
        generator._bufferRecyclable = true;
        // Act
        generator._releaseBuffers();
        // Assert
        assertNull(generator._outputBuffer, "Output buffer should be released");
        assertNull(generator._charBuffer, "Char buffer should be released");
    }

    @Test
    public void testReleaseBuffers_WhenOutputBufferIsNull() {
        // Arrange
        generator._outputBuffer = null;
        generator._charBuffer = new char[512];
        generator._bufferRecyclable = true;
        // Act
        generator._releaseBuffers();
        // Assert
        assertNull(generator._charBuffer, "Char buffer should be released");
    }

    @Test
    public void testReleaseBuffers_WhenCharBufferIsNull() {
        // Arrange
        generator._outputBuffer = new byte[512];
        generator._charBuffer = null;
        generator._bufferRecyclable = true;
        // Act
        generator._releaseBuffers();
        // Assert
        assertNull(generator._outputBuffer, "Output buffer should be released");
    }

    @Test
    public void testReleaseBuffers_WhenBuffersAreNotRecyclable() {
        // Arrange
        generator._outputBuffer = new byte[512];
        generator._charBuffer = new char[512];
        generator._bufferRecyclable = false;
        // Act
        generator._releaseBuffers();
        // Assert
        assertNotNull(generator._outputBuffer, "Output buffer should not be released");
        assertNotNull(generator._charBuffer, "Char buffer should not be released");
    }
}
