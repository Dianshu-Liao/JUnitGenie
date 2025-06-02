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

@ExtendWith(MockitoExtension.class)
public class BaseNCodecOutputStream_eof_1_0_Test {

    private BaseNCodecOutputStream outputStream;

    private BaseNCodec mockBaseNCodec;

    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    public void setUp() {
        mockBaseNCodec = mock(BaseNCodec.class);
        byteArrayOutputStream = new ByteArrayOutputStream();
        // Set to encode
        outputStream = new BaseNCodecOutputStream(byteArrayOutputStream, mockBaseNCodec, true);
    }

    @Test
    public void testEofEncode() throws IOException {
        outputStream.eof();
        verify(mockBaseNCodec, times(1)).encode(any(byte[].class), eq(0), eq(-1), any(BaseNCodec.Context.class));
    }

    @Test
    public void testEofDecode() throws IOException {
        // Set to decode
        outputStream = new BaseNCodecOutputStream(byteArrayOutputStream, mockBaseNCodec, false);
        outputStream.eof();
        verify(mockBaseNCodec, times(1)).decode(any(byte[].class), eq(0), eq(-1), any(BaseNCodec.Context.class));
    }

    @Test
    public void testEofWithoutEncoding() throws IOException {
        outputStream = new BaseNCodecOutputStream(byteArrayOutputStream, mockBaseNCodec, false);
        outputStream.eof();
        verify(mockBaseNCodec, times(1)).decode(any(byte[].class), eq(0), eq(-1), any(BaseNCodec.Context.class));
    }

    @Test
    public void testEofWithEncoding() throws IOException {
        outputStream.eof();
        verify(mockBaseNCodec, times(1)).encode(any(byte[].class), eq(0), eq(-1), any(BaseNCodec.Context.class));
    }
}
