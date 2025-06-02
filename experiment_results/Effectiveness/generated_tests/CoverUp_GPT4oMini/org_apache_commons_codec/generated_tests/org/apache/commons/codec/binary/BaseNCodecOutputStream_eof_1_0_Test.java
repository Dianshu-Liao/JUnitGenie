package org.apache.commons.codec.binary;

import java.io.OutputStream;
import org.apache.commons.codec.binary.BaseNCodec;
import org.apache.commons.codec.binary.BaseNCodec.Context;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.codec.binary.BaseNCodec.EOF;
import java.io.IOException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.FilterOutputStream;
import java.util.Objects;

@ExtendWith(MockitoExtension.class)
class BaseNCodecOutputStream_eof_1_0_Test {

    private BaseNCodecOutputStream baseNCodecOutputStream;

    private BaseNCodec mockBaseNCodec;

    private OutputStream mockOutputStream;

    @BeforeEach
    void setUp() {
        mockBaseNCodec = mock(BaseNCodec.class);
        mockOutputStream = mock(OutputStream.class);
    }

    @Test
    void testEofWhenDoEncodeIsTrue() throws Exception {
        baseNCodecOutputStream = new BaseNCodecOutputStream(mockOutputStream, mockBaseNCodec, true);
        // Invoke the private method using reflection
        Method method = BaseNCodecOutputStream.class.getDeclaredMethod("eof");
        method.setAccessible(true);
        // Call the eof method
        method.invoke(baseNCodecOutputStream);
        // Verify that encode was called with the correct parameters
        verify(mockBaseNCodec).encode(any(byte[].class), eq(0), eq(BaseNCodec.EOF), any(Context.class));
    }

    @Test
    void testEofWhenDoEncodeIsFalse() throws Exception {
        baseNCodecOutputStream = new BaseNCodecOutputStream(mockOutputStream, mockBaseNCodec, false);
        // Invoke the private method using reflection
        Method method = BaseNCodecOutputStream.class.getDeclaredMethod("eof");
        method.setAccessible(true);
        // Call the eof method
        method.invoke(baseNCodecOutputStream);
        // Verify that decode was called with the correct parameters
        verify(mockBaseNCodec).decode(any(byte[].class), eq(0), eq(BaseNCodec.EOF), any(Context.class));
    }
}
