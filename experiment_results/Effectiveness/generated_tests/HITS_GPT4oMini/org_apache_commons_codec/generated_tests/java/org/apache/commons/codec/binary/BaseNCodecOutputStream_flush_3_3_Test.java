package org.apache.commons.codec.binary;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.codec.binary.BaseNCodec.EOF;
import java.io.FilterOutputStream;
import java.util.Objects;
import org.apache.commons.codec.binary.BaseNCodec.Context;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class BaseNCodecOutputStream_flush_3_3_Test {

    private BaseNCodecOutputStream baseNCodecOutputStream;

    private OutputStream mockOutputStream;

    private BaseNCodec mockBaseNCodec;

    @BeforeEach
    public void setUp() {
        mockOutputStream = mock(OutputStream.class);
        mockBaseNCodec = mock(BaseNCodec.class);
        baseNCodecOutputStream = new BaseNCodecOutputStream(mockOutputStream, mockBaseNCodec, true);
    }

    private void invokeFlush(boolean propagate) throws Exception {
        Method flushMethod = BaseNCodecOutputStream.class.getDeclaredMethod("flush", boolean.class);
        flushMethod.setAccessible(true);
        flushMethod.invoke(baseNCodecOutputStream, propagate);
    }

    @Test
    public void testFlushWithPropagateWhenAvailableData() throws Exception {
        // Arrange
        byte[] expectedOutput = { 1, 2, 3 };
        when(mockBaseNCodec.available(any())).thenReturn(expectedOutput.length);
        when(mockBaseNCodec.readResults(any(byte[].class), anyInt(), anyInt(), any())).thenReturn(expectedOutput.length);
        // Act
        invokeFlush(true);
        // Assert
        ArgumentCaptor<byte[]> byteArrayCaptor = ArgumentCaptor.forClass(byte[].class);
        verify(mockOutputStream).write(byteArrayCaptor.capture(), eq(0), eq(expectedOutput.length));
        assertArrayEquals(expectedOutput, byteArrayCaptor.getValue());
        verify(mockOutputStream).flush();
    }

    @Test
    public void testFlushWithoutPropagateWhenAvailableData() throws Exception {
        // Arrange
        byte[] expectedOutput = { 1, 2, 3 };
        when(mockBaseNCodec.available(any())).thenReturn(expectedOutput.length);
        when(mockBaseNCodec.readResults(any(byte[].class), anyInt(), anyInt(), any())).thenReturn(expectedOutput.length);
        // Act
        invokeFlush(false);
        // Assert
        ArgumentCaptor<byte[]> byteArrayCaptor = ArgumentCaptor.forClass(byte[].class);
        verify(mockOutputStream).write(byteArrayCaptor.capture(), eq(0), eq(expectedOutput.length));
        assertArrayEquals(expectedOutput, byteArrayCaptor.getValue());
        verify(mockOutputStream, never()).flush();
    }

    @Test
    public void testFlushWhenNoAvailableData() throws Exception {
        // Arrange
        when(mockBaseNCodec.available(any())).thenReturn(0);
        // Act
        invokeFlush(true);
        // Assert
        verify(mockOutputStream, never()).write(any(byte[].class), anyInt(), anyInt());
        verify(mockOutputStream).flush();
    }
}
