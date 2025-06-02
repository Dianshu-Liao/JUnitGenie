package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
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

class UTF8JsonGenerator__releaseBuffers_50_1_Test {

    private IOContext mockIOContext;

    private UTF8JsonGenerator generator;

    @BeforeEach
    void setUp() {
        mockIOContext = mock(IOContext.class);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        generator = new UTF8JsonGenerator(mockIOContext, 0, null, outputStream, '"', new byte[512], 0, true);
    }

    @Test
    void testReleaseBuffers_WhenBuffersAreRecyclable() {
        // Arrange
        generator._outputBuffer = new byte[512];
        generator._charBuffer = new char[256];
        generator._bufferRecyclable = true;
        // Act
        invokePrivateReleaseBuffers(generator);
        // Assert
        assertNull(generator._outputBuffer);
        assertNull(generator._charBuffer);
        verify(mockIOContext, times(1)).releaseWriteEncodingBuffer(any(byte[].class));
        verify(mockIOContext, times(1)).releaseConcatBuffer(any(char[].class));
    }

    @Test
    void testReleaseBuffers_WhenOutputBufferIsNull() {
        // Arrange
        generator._charBuffer = new char[256];
        generator._bufferRecyclable = true;
        // Act
        invokePrivateReleaseBuffers(generator);
        // Assert
        assertNull(generator._outputBuffer);
        assertNull(generator._charBuffer);
        verify(mockIOContext, times(0)).releaseWriteEncodingBuffer(any(byte[].class));
        verify(mockIOContext, times(1)).releaseConcatBuffer(any(char[].class));
    }

    @Test
    void testReleaseBuffers_WhenCharBufferIsNull() {
        // Arrange
        generator._outputBuffer = new byte[512];
        generator._bufferRecyclable = true;
        // Act
        invokePrivateReleaseBuffers(generator);
        // Assert
        assertNull(generator._outputBuffer);
        assertNull(generator._charBuffer);
        verify(mockIOContext, times(1)).releaseWriteEncodingBuffer(any(byte[].class));
        verify(mockIOContext, times(0)).releaseConcatBuffer(any(char[].class));
    }

    @Test
    void testReleaseBuffers_WhenBuffersAreNotRecyclable() {
        // Arrange
        generator._outputBuffer = new byte[512];
        generator._charBuffer = new char[256];
        generator._bufferRecyclable = false;
        // Act
        invokePrivateReleaseBuffers(generator);
        // Assert
        assertNotNull(generator._outputBuffer);
        assertNotNull(generator._charBuffer);
        verify(mockIOContext, times(0)).releaseWriteEncodingBuffer(any(byte[].class));
        verify(mockIOContext, times(0)).releaseConcatBuffer(any(char[].class));
    }

    private void invokePrivateReleaseBuffers(UTF8JsonGenerator generator) {
        try {
            Method method = UTF8JsonGenerator.class.getDeclaredMethod("_releaseBuffers");
            method.setAccessible(true);
            method.invoke(generator);
        } catch (Exception e) {
            fail("Exception while invoking _releaseBuffers: " + e.getMessage());
        }
    }
}
