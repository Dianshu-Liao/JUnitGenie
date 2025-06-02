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

class UTF8JsonGenerator__releaseBuffers_50_0_Test {

    private UTF8JsonGenerator generator;

    private IOContext mockIOContext;

    private ObjectCodec mockCodec;

    private OutputStream mockOutputStream;

    @BeforeEach
    void setUp() {
        mockIOContext = mock(IOContext.class);
        mockCodec = mock(ObjectCodec.class);
        mockOutputStream = mock(OutputStream.class);
        // Fixed the buggy line by changing byte to char
        char quoteChar = '"';
        generator = new UTF8JsonGenerator(mockIOContext, 0, mockCodec, mockOutputStream, quoteChar);
        generator._outputBuffer = new byte[512];
        generator._charBuffer = new char[512];
        generator._bufferRecyclable = true;
    }

    @Test
    void testReleaseBuffers_whenBufferRecyclable() {
        generator._releaseBuffers();
        // Verify that the output buffer is released
        assertNull(generator._outputBuffer);
        verify(mockIOContext, times(1)).releaseWriteEncodingBuffer(any(byte[].class));
        // Verify that the char buffer is released
        assertNull(generator._charBuffer);
        verify(mockIOContext, times(1)).releaseConcatBuffer(any(char[].class));
    }

    @Test
    void testReleaseBuffers_whenBufferNotRecyclable() {
        generator._bufferRecyclable = false;
        generator._releaseBuffers();
        // Verify that the output buffer is not released
        assertNotNull(generator._outputBuffer);
        verify(mockIOContext, never()).releaseWriteEncodingBuffer(any(byte[].class));
        // Verify that the char buffer is released
        assertNull(generator._charBuffer);
        verify(mockIOContext, times(1)).releaseConcatBuffer(any(char[].class));
    }

    @Test
    void testReleaseBuffers_whenBuffersAreNull() {
        generator._outputBuffer = null;
        generator._charBuffer = null;
        generator._bufferRecyclable = true;
        generator._releaseBuffers();
        // Both buffers should still be null
        assertNull(generator._outputBuffer);
        assertNull(generator._charBuffer);
        verify(mockIOContext, never()).releaseWriteEncodingBuffer(any(byte[].class));
        verify(mockIOContext, never()).releaseConcatBuffer(any(char[].class));
    }
}
