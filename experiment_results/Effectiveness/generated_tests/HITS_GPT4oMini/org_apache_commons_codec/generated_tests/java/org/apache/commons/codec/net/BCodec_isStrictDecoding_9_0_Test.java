package org.apache.commons.codec.net;

import org.apache.commons.codec.CodecPolicy;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.BaseNCodec;

public class BCodec_isStrictDecoding_9_0_Test {

    private BCodec lenientCodec;

    private BCodec strictCodec;

    @BeforeEach
    public void setUp() {
        lenientCodec = new BCodec(Charset.defaultCharset(), CodecPolicy.LENIENT);
        strictCodec = new BCodec(Charset.defaultCharset(), CodecPolicy.STRICT);
    }

    @Test
    public void testIsStrictDecodingWithLenientPolicy() {
        // Test when decodingPolicy is LENIENT
        assertFalse(lenientCodec.isStrictDecoding(), "Expected isStrictDecoding to return false for LENIENT policy");
    }

    @Test
    public void testIsStrictDecodingWithStrictPolicy() {
        // Test when decodingPolicy is STRICT
        assertTrue(strictCodec.isStrictDecoding(), "Expected isStrictDecoding to return true for STRICT policy");
    }
}
