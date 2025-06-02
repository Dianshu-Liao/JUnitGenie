package org.apache.commons.codec.binary;

import java.io.OutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.codec.binary.BaseNCodec.EOF;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.util.Objects;
import org.apache.commons.codec.binary.BaseNCodec.Context;

public class BaseNCodecOutputStream_eof_1_0_Test {

    private BaseNCodecOutputStream baseNCodecOutputStream;

    private BaseNCodec baseNCodecMock;

    private OutputStream outputStreamMock;

    @BeforeEach
    public void setUp() {
        outputStreamMock = mock(OutputStream.class);
        baseNCodecMock = mock(BaseNCodec.class);
    }

    @Test
    public void testEofWhenDoEncodeIsTrue() throws Exception {
        // Arrange
        baseNCodecOutputStream = new BaseNCodecOutputStream(outputStreamMock, baseNCodecMock, true);
        byte[] singleByte = new byte[1];
        // Act
        baseNCodecOutputStream.eof();
        // Assert
        ArgumentCaptor<byte[]> byteArrayCaptor = ArgumentCaptor.forClass(byte[].class);
        verify(baseNCodecMock).encode(byteArrayCaptor.capture(), eq(0), eq(-1), any(Context.class));
        assertArrayEquals(singleByte, byteArrayCaptor.getValue());
    }

    @Test
    public void testEofWhenDoEncodeIsFalse() throws Exception {
        // Arrange
        baseNCodecOutputStream = new BaseNCodecOutputStream(outputStreamMock, baseNCodecMock, false);
        byte[] singleByte = new byte[1];
        // Act
        baseNCodecOutputStream.eof();
        // Assert
        ArgumentCaptor<byte[]> byteArrayCaptor = ArgumentCaptor.forClass(byte[].class);
        verify(baseNCodecMock).decode(byteArrayCaptor.capture(), eq(0), eq(-1), any(Context.class));
        assertArrayEquals(singleByte, byteArrayCaptor.getValue());
    }
}
