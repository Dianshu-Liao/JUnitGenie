package org.apache.commons.codec.binary;

import java.io.IOException;
import java.io.InputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.codec.binary.BaseNCodec.EOF;
import java.io.FilterInputStream;
import java.util.Objects;
import org.apache.commons.codec.binary.BaseNCodec.Context;

public class BaseNCodecInputStream_skip_7_0_Test {

    private BaseNCodecInputStream baseNCodecInputStream;

    private InputStream mockInputStream;

    private BaseNCodec mockBaseNCodec;

    @BeforeEach
    public void setUp() {
        mockInputStream = Mockito.mock(InputStream.class);
        mockBaseNCodec = Mockito.mock(BaseNCodec.class);
        baseNCodecInputStream = new BaseNCodecInputStream(mockInputStream, mockBaseNCodec, true);
    }

    @Test
    public void testSkipNegative() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            baseNCodecInputStream.skip(-1);
        });
        assertEquals("Negative skip length: -1", exception.getMessage());
    }

    @Test
    public void testSkipZero() throws IOException {
        long skipped = baseNCodecInputStream.skip(0);
        assertEquals(0, skipped);
    }

    @Test
    public void testSkipLessThanBuffer() throws IOException {
        Mockito.when(mockInputStream.read(Mockito.any(byte[].class), Mockito.eq(0), Mockito.anyInt())).thenReturn(5);
        long skipped = baseNCodecInputStream.skip(5);
        assertEquals(5, skipped);
    }

    @Test
    public void testSkipMoreThanBuffer() throws IOException {
        Mockito.when(mockInputStream.read(Mockito.any(byte[].class), Mockito.eq(0), Mockito.anyInt())).thenReturn(512).thenReturn(300).thenReturn(-1);
        long skipped = baseNCodecInputStream.skip(800);
        assertEquals(800, skipped);
    }

    @Test
    public void testSkipUntilEOF() throws IOException {
        Mockito.when(mockInputStream.read(Mockito.any(byte[].class), Mockito.eq(0), Mockito.anyInt())).thenReturn(512).thenReturn(512).thenReturn(-1);
        long skipped = baseNCodecInputStream.skip(1200);
        assertEquals(1024, skipped);
    }
}
