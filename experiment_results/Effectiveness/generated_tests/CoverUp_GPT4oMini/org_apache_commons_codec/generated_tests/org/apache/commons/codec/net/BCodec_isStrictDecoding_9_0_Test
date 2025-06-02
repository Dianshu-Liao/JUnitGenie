package org.apache.commons.codec.net;

import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.CodecPolicy;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.BaseNCodec;

public class BCodec_isStrictDecoding_9_0_Test {

    private BCodec bCodec;

    @BeforeEach
    public void setUp() {
        bCodec = new BCodec();
    }

    @Test
    public void testIsStrictDecodingDefaultPolicy() throws Exception {
        // Using reflection to access the private field `decodingPolicy`
        Method method = BCodec.class.getDeclaredMethod("isStrictDecoding");
        method.setAccessible(true);
        // Default policy is LENIENT, so it should return false
        boolean result = (boolean) method.invoke(bCodec);
        assertFalse(result);
    }

    @Test
    public void testIsStrictDecodingStrictPolicy() throws Exception {
        // Create an instance of BCodec with STRICT policy
        bCodec = new BCodec(StandardCharsets.UTF_8, CodecPolicy.STRICT);
        // Using reflection to access the private method `isStrictDecoding`
        Method method = BCodec.class.getDeclaredMethod("isStrictDecoding");
        method.setAccessible(true);
        // Should return true since the decoding policy is STRICT
        boolean result = (boolean) method.invoke(bCodec);
        assertTrue(result);
    }

    @Test
    public void testIsStrictDecodingLenientPolicy() throws Exception {
        // Create an instance of BCodec with LENIENT policy
        bCodec = new BCodec(StandardCharsets.UTF_8, CodecPolicy.LENIENT);
        // Using reflection to access the private method `isStrictDecoding`
        Method method = BCodec.class.getDeclaredMethod("isStrictDecoding");
        method.setAccessible(true);
        // Should return false since the decoding policy is LENIENT
        boolean result = (boolean) method.invoke(bCodec);
        assertFalse(result);
    }
}
