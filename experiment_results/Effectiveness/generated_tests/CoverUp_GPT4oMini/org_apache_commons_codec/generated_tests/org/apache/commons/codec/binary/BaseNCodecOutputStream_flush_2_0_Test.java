package org.apache.commons.codec.binary;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.codec.binary.BaseNCodec;
import org.apache.commons.codec.binary.BaseNCodecOutputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.codec.binary.BaseNCodec.EOF;
import java.io.FilterOutputStream;
import java.lang.reflect.Method;
import java.util.Objects;
import org.apache.commons.codec.binary.BaseNCodec.Context;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class BaseNCodecOutputStream_flush_2_0_Test {

    private BaseNCodecOutputStream baseNCodecOutputStream;

    private ByteArrayOutputStream byteArrayOutputStream;

    private BaseNCodec baseNCodec;

    @BeforeEach
    void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        baseNCodec = mock(BaseNCodec.class);
        baseNCodecOutputStream = new BaseNCodecOutputStream(byteArrayOutputStream, baseNCodec, true);
    }

    @Test
    void testFlushWithAvailableData() throws IOException {
        // Arrange
        when(baseNCodec.available(any())).thenReturn(5);
        when(baseNCodec.readResults(any(byte[].class), anyInt(), anyInt(), any())).thenReturn(5);
        // Act
        baseNCodecOutputStream.flush();
        // Assert
        verify(baseNCodec).available(any());
        verify(baseNCodec).readResults(any(byte[].class), anyInt(), anyInt(), any());
        assertEquals(5, byteArrayOutputStream.size());
    }

    @Test
    void testFlushWithNoAvailableData() throws IOException {
        // Arrange
        when(baseNCodec.available(any())).thenReturn(0);
        // Act
        baseNCodecOutputStream.flush();
        // Assert
        verify(baseNCodec).available(any());
        verify(baseNCodec, never()).readResults(any(byte[].class), anyInt(), anyInt(), any());
        assertEquals(0, byteArrayOutputStream.size());
    }

    @Test
    void testFlushPropagateTrue() throws IOException {
        // Arrange
        when(baseNCodec.available(any())).thenReturn(5);
        when(baseNCodec.readResults(any(byte[].class), anyInt(), anyInt(), any())).thenReturn(5);
        // Act
        baseNCodecOutputStream.flush();
        // Assert
        assertEquals(5, byteArrayOutputStream.size());
        assertTrue(byteArrayOutputStream.toByteArray().length > 0);
    }

    @Test
    void testFlushPropagateFalse() throws IOException {
        // Arrange
        when(baseNCodec.available(any())).thenReturn(5);
        when(baseNCodec.readResults(any(byte[].class), anyInt(), anyInt(), any())).thenReturn(5);
        // Act
        invokePrivateFlushMethod(false);
        // Assert
        assertEquals(5, byteArrayOutputStream.size());
    }

    private void invokePrivateFlushMethod(boolean propagate) throws IOException {
        try {
            Method method = BaseNCodecOutputStream.class.getDeclaredMethod("flush", boolean.class);
            method.setAccessible(true);
            method.invoke(baseNCodecOutputStream, propagate);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
