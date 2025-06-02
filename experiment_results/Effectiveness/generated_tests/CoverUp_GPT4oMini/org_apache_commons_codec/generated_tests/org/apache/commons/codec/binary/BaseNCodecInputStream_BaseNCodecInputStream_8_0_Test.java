package org.apache.commons.codec.binary;

import java.io.InputStream;
import org.apache.commons.codec.binary.BaseNCodec;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.codec.binary.BaseNCodec.EOF;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Objects;
import org.apache.commons.codec.binary.BaseNCodec.Context;

public class BaseNCodecInputStream_BaseNCodecInputStream_8_0_Test {

    private BaseNCodecInputStream baseNCodecInputStream;

    private InputStream mockInputStream;

    private BaseNCodec mockBaseNCodec;

    @BeforeEach
    public void setUp() {
        mockInputStream = mock(InputStream.class);
        mockBaseNCodec = mock(BaseNCodec.class);
    }

    @Test
    public void testConstructorWithEncode() {
        baseNCodecInputStream = new BaseNCodecInputStream(mockInputStream, mockBaseNCodec, true);
        assertNotNull(baseNCodecInputStream);
    }

    @Test
    public void testConstructorWithDecode() {
        baseNCodecInputStream = new BaseNCodecInputStream(mockInputStream, mockBaseNCodec, false);
        assertNotNull(baseNCodecInputStream);
    }

    @Test
    public void testConstructorWithNullInputStream() {
        baseNCodecInputStream = new BaseNCodecInputStream(null, mockBaseNCodec, true);
        assertNotNull(baseNCodecInputStream);
    }

    @Test
    public void testConstructorWithNullBaseNCodec() {
        baseNCodecInputStream = new BaseNCodecInputStream(mockInputStream, null, true);
        assertNotNull(baseNCodecInputStream);
    }
}
