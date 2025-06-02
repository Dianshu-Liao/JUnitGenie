package org.apache.commons.codec.binary;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.codec.binary.BaseNCodec.EOF;
import java.io.FilterOutputStream;
import java.util.Objects;
import org.apache.commons.codec.binary.BaseNCodec.Context;

public class BaseNCodecOutputStream_flush_3_0_Test {

    private BaseNCodecOutputStream baseNCodecOutputStream;

    private OutputStream mockOutputStream;

    private BaseNCodec mockBaseNCodec;

    private Context mockContext;

    @BeforeEach
    public void setUp() {
        mockOutputStream = mock(ByteArrayOutputStream.class);
        mockBaseNCodec = mock(BaseNCodec.class);
        mockContext = mock(Context.class);
        baseNCodecOutputStream = new BaseNCodecOutputStream(mockOutputStream, mockBaseNCodec, true);
    }

    @Test
    public void testFlush_PropagateTrue_AvailableData() throws Exception {
        // Arrange
        when(mockBaseNCodec.available(mockContext)).thenReturn(5);
        when(mockBaseNCodec.readResults(any(byte[].class), anyInt(), anyInt(), any(Context.class))).thenReturn(5);
        // Act
        invokeFlushMethod(true);
        // Assert
        verify(mockOutputStream).write(any(byte[].class), anyInt(), anyInt());
        verify(mockOutputStream).flush();
    }

    @Test
    public void testFlush_PropagateTrue_NoAvailableData() throws Exception {
        // Arrange
        when(mockBaseNCodec.available(mockContext)).thenReturn(0);
        // Act
        invokeFlushMethod(true);
        // Assert
        verify(mockOutputStream, never()).write(any(byte[].class), anyInt(), anyInt());
        verify(mockOutputStream).flush();
    }

    @Test
    public void testFlush_PropagateFalse_AvailableData() throws Exception {
        // Arrange
        when(mockBaseNCodec.available(mockContext)).thenReturn(3);
        when(mockBaseNCodec.readResults(any(byte[].class), anyInt(), anyInt(), any(Context.class))).thenReturn(3);
        // Act
        invokeFlushMethod(false);
        // Assert
        verify(mockOutputStream).write(any(byte[].class), anyInt(), anyInt());
        verify(mockOutputStream, never()).flush();
    }

    @Test
    public void testFlush_PropagateFalse_NoAvailableData() throws Exception {
        // Arrange
        when(mockBaseNCodec.available(mockContext)).thenReturn(0);
        // Act
        invokeFlushMethod(false);
        // Assert
        verify(mockOutputStream, never()).write(any(byte[].class), anyInt(), anyInt());
        verify(mockOutputStream, never()).flush();
    }

    private void invokeFlushMethod(boolean propagate) throws Exception {
        java.lang.reflect.Method method = BaseNCodecOutputStream.class.getDeclaredMethod("flush", boolean.class);
        method.setAccessible(true);
        method.invoke(baseNCodecOutputStream, propagate);
    }
}
