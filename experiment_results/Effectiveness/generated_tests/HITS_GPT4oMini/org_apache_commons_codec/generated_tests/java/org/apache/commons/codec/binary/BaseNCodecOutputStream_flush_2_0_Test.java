package org.apache.commons.codec.binary;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.codec.binary.BaseNCodec.EOF;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.Objects;
import org.apache.commons.codec.binary.BaseNCodec.Context;

public class BaseNCodecOutputStream_flush_2_0_Test {

    private BaseNCodecOutputStream codecOutputStream;

    private BaseNCodec mockBaseNCodec;

    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    public void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        mockBaseNCodec = mock(BaseNCodec.class);
        codecOutputStream = new BaseNCodecOutputStream(byteArrayOutputStream, mockBaseNCodec, true);
    }

    @Test
    public void testFlushWithAvailableData() throws IOException {
        // Arrange
        when(mockBaseNCodec.available(any())).thenReturn(4);
        when(mockBaseNCodec.readResults(any(byte[].class), eq(0), eq(4), any())).thenReturn(4);
        byte[] expectedOutput = { 1, 2, 3, 4 };
        // Act
        codecOutputStream.flush();
        // Assert
        assertArrayEquals(expectedOutput, byteArrayOutputStream.toByteArray());
        verify(mockBaseNCodec).available(any());
        verify(mockBaseNCodec).readResults(any(byte[].class), eq(0), eq(4), any());
    }

    @Test
    public void testFlushWithNoAvailableData() throws IOException {
        // Arrange
        when(mockBaseNCodec.available(any())).thenReturn(0);
        // Act
        codecOutputStream.flush();
        // Assert
        assertArrayEquals(new byte[0], byteArrayOutputStream.toByteArray());
        verify(mockBaseNCodec).available(any());
        verify(mockBaseNCodec, never()).readResults(any(byte[].class), anyInt(), anyInt(), any());
    }

    @Test
    public void testFlushHandlesIOException() {
        // Arrange
        when(mockBaseNCodec.available(any())).thenThrow(new IOException("Test Exception"));
        // Act & Assert
        assertThrows(IOException.class, () -> {
            codecOutputStream.flush();
        });
        verify(mockBaseNCodec).available(any());
    }
}
