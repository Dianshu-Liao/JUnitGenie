package org.apache.commons.codec.net;

import java.nio.charset.Charset;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.BaseNCodec;

class BCodec_isStrictDecoding_9_0_Test {

    @Test
    void testIsStrictDecodingWithDefaultPolicy() {
        BCodec bCodec = new BCodec();
        assertFalse(bCodec.isStrictDecoding());
    }

    @Test
    void testIsStrictDecodingWithLenientPolicy() {
        BCodec bCodec = new BCodec(Charset.defaultCharset(), CodecPolicy.LENIENT);
        assertFalse(bCodec.isStrictDecoding());
    }

    @Test
    void testIsStrictDecodingWithStrictPolicy() {
        BCodec bCodec = new BCodec(Charset.defaultCharset(), CodecPolicy.STRICT);
        assertTrue(bCodec.isStrictDecoding());
    }

    @Test
    void testIsStrictDecodingWithCharsetName() {
        BCodec bCodec = new BCodec("UTF-8");
        // Assuming default policy is LENIENT
        assertFalse(bCodec.isStrictDecoding());
    }
}
