package org.apache.commons.codec.binary;

import java.io.InputStream;
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

    private InputStream inputStream;

    private BaseNCodec baseNCodec;

    private boolean doEncode;

    @BeforeEach
    public void setUp() {
        inputStream = mock(InputStream.class);
        baseNCodec = mock(BaseNCodec.class);
        // Change this to false to test decoding
        doEncode = true;
    }

    @Test
    public void testBaseNCodecInputStreamInitialization() {
        BaseNCodecInputStream codecInputStream = new BaseNCodecInputStream(inputStream, baseNCodec, doEncode);
        assertNotNull(codecInputStream);
    }

    @Test
    public void testBaseNCodecInputStreamInitializationWithDifferentEncoding() {
        // Testing with decoding
        doEncode = false;
        BaseNCodecInputStream codecInputStream = new BaseNCodecInputStream(inputStream, baseNCodec, doEncode);
        assertNotNull(codecInputStream);
    }
}
