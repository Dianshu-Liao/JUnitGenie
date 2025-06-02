package org.apache.commons.codec.binary;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.OutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.apache.commons.codec.binary.BaseNCodec.EOF;
import java.io.FilterOutputStream;
import java.util.Objects;
import org.apache.commons.codec.binary.BaseNCodec.Context;

@ExtendWith(MockitoExtension.class)
class BaseNCodecOutputStream_flush_3_0_Test {

    private BaseNCodecOutputStream baseNCodecOutputStream;

    private ByteArrayOutputStream outputStream;

    private BaseNCodec mockBaseNCodec;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        mockBaseNCodec = mock(BaseNCodec.class);
        baseNCodecOutputStream = new BaseNCodecOutputStream(outputStream, mockBaseNCodec, true);
    }

    @Test
    void testFlushWithPropagate() throws IOException {
        // Arrange
        byte[] expectedOutput = { 1, 2, 3 };
        when(mockBaseNCodec.available(any())).thenReturn(expectedOutput.length);
        when(mockBaseNCodec.readResults(any(byte[].class), anyInt(), anyInt(), any())).thenReturn(expectedOutput.length);
        // Act
        // Call the flush method via reflection
        invokeFlushMethod(true);
        // Assert
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    void testFlushWithoutPropagate() throws IOException {
        // Arrange
        byte[] expectedOutput = { 4, 5, 6 };
        when(mockBaseNCodec.available(any())).thenReturn(expectedOutput.length);
        when(mockBaseNCodec.readResults(any(byte[].class), anyInt(), anyInt(), any())).thenReturn(expectedOutput.length);
        // Act
        // Call the flush method via reflection
        invokeFlushMethod(false);
        // Assert
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
        // Verify that out.flush() was not called
        verify(outputStream, never()).flush();
    }

    private void invokeFlushMethod(boolean propagate) throws IOException {
        try {
            // Use reflection to access the private flush method
            java.lang.reflect.Method method = BaseNCodecOutputStream.class.getDeclaredMethod("flush", boolean.class);
            method.setAccessible(true);
            method.invoke(baseNCodecOutputStream, propagate);
        } catch (Exception e) {
            throw new IOException("Unable to invoke flush method", e);
        }
    }
}
