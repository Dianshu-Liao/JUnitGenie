package com.fasterxml.jackson.core.json;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8StreamJsonParser__releaseBuffers_4_0_Test {

    @Mock
    private IOContext mockIOContext;

    @Mock
    private ObjectCodec mockCodec;

    @Mock
    private ByteQuadsCanonicalizer mockSymbols;

    private UTF8StreamJsonParser parser;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        parser = new UTF8StreamJsonParser(mockIOContext, 0, mock(InputStream.class), mockCodec, mockSymbols, new byte[10], 0, 10, true);
    }

    @Test
    public void testReleaseBuffers_WithBufferRecyclable_NonNullBuffer() throws Exception {
        // Arrange
        byte[] inputBuffer = new byte[10];
        parser._inputBuffer = inputBuffer;
        // Act
        invokeReleaseBuffers(parser);
        // Assert
        assertNull(parser._inputBuffer);
        verify(mockSymbols).release();
        verify(mockIOContext).releaseReadIOBuffer(inputBuffer);
    }

    @Test
    public void testReleaseBuffers_WithBufferRecyclable_NullBuffer() throws Exception {
        // Arrange
        parser._inputBuffer = null;
        // Act
        invokeReleaseBuffers(parser);
        // Assert
        assertNull(parser._inputBuffer);
        verify(mockSymbols).release();
        verify(mockIOContext, never()).releaseReadIOBuffer(any());
    }

    @Test
    public void testReleaseBuffers_WithBufferNotRecyclable() throws Exception {
        // Arrange
        parser._bufferRecyclable = false;
        byte[] inputBuffer = new byte[10];
        parser._inputBuffer = inputBuffer;
        // Act
        invokeReleaseBuffers(parser);
        // Assert
        assertEquals(inputBuffer, parser._inputBuffer);
        verify(mockSymbols).release();
        verify(mockIOContext, never()).releaseReadIOBuffer(any());
    }

    private void invokeReleaseBuffers(UTF8StreamJsonParser parser) throws Exception {
        // Fixed Buggy Line: Changed 'var' to 'Method' to declare the method variable correctly
        java.lang.reflect.Method method = UTF8StreamJsonParser.class.getDeclaredMethod("_releaseBuffers");
        method.setAccessible(true);
        method.invoke(parser);
    }
}
