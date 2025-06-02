package org.apache.commons.codec.binary;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.codec.binary.BaseNCodec;
import org.apache.commons.codec.binary.BaseNCodec.Context;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.apache.commons.codec.binary.BaseNCodec.EOF;
import java.io.FilterOutputStream;
import java.util.Objects;

class BaseNCodecOutputStream_flush_3_0_Test {

    private BaseNCodecOutputStream baseNCodecOutputStream;

    private OutputStream outputStream;

    private BaseNCodec baseNCodec;

    @BeforeEach
    void setUp() {
        outputStream = mock(OutputStream.class);
        baseNCodec = mock(BaseNCodec.class);
        baseNCodecOutputStream = new BaseNCodecOutputStream(outputStream, baseNCodec, true);
    }

    @Test
    void testFlushWithPropagateTrueAndAvailableData() throws Exception {
        // Arrange
        Context context = new Context();
        when(baseNCodec.available(context)).thenReturn(5);
        when(baseNCodec.readResults(any(byte[].class), anyInt(), anyInt(), eq(context))).thenReturn(5);
        // Act
        invokeFlush(true);
        // Assert
        verify(baseNCodec).available(context);
        verify(baseNCodec).readResults(any(byte[].class), anyInt(), anyInt(), eq(context));
        verify(outputStream).write(any(byte[].class), eq(0), eq(5));
        verify(outputStream).flush();
    }

    @Test
    void testFlushWithPropagateTrueAndNoAvailableData() throws Exception {
        // Arrange
        Context context = new Context();
        when(baseNCodec.available(context)).thenReturn(0);
        // Act
        invokeFlush(true);
        // Assert
        verify(baseNCodec).available(context);
        verify(outputStream, never()).write(any(byte[].class), anyInt(), anyInt());
        verify(outputStream).flush();
    }

    @Test
    void testFlushWithPropagateFalseAndAvailableData() throws Exception {
        // Arrange
        Context context = new Context();
        when(baseNCodec.available(context)).thenReturn(3);
        when(baseNCodec.readResults(any(byte[].class), anyInt(), anyInt(), eq(context))).thenReturn(3);
        // Act
        invokeFlush(false);
        // Assert
        verify(baseNCodec).available(context);
        verify(baseNCodec).readResults(any(byte[].class), anyInt(), anyInt(), eq(context));
        verify(outputStream).write(any(byte[].class), eq(0), eq(3));
        verify(outputStream, never()).flush();
    }

    @Test
    void testFlushWithPropagateFalseAndNoAvailableData() throws Exception {
        // Arrange
        Context context = new Context();
        when(baseNCodec.available(context)).thenReturn(0);
        // Act
        invokeFlush(false);
        // Assert
        verify(baseNCodec).available(context);
        verify(outputStream, never()).write(any(byte[].class), anyInt(), anyInt());
        verify(outputStream, never()).flush();
    }

    private void invokeFlush(boolean propagate) throws Exception {
        Method method = BaseNCodecOutputStream.class.getDeclaredMethod("flush", boolean.class);
        method.setAccessible(true);
        method.invoke(baseNCodecOutputStream, propagate);
    }
}
