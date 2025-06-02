package org.apache.commons.codec.net;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.BCodec;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.BaseNCodec;

public class BCodec_encode_4_0_Test {

    private BCodec bCodec;

    @BeforeEach
    public void setUp() {
        bCodec = new BCodec(StandardCharsets.UTF_8);
    }

    @Test
    public void testEncode_NullValue() throws EncoderException {
        Object result = bCodec.encode(null);
        assertNull(result);
    }

    @Test
    public void testEncode_StringValue() throws Exception {
        String input = "test";
        Method encodeMethod = BCodec.class.getDeclaredMethod("encode", String.class);
        encodeMethod.setAccessible(true);
        String result = (String) encodeMethod.invoke(bCodec, input);
        // Assuming encode(String) returns the same string for simplicity
        assertEquals("test", result);
    }

    @Test
    public void testEncode_InvalidObjectType() {
        Object input = new Object();
        EncoderException exception = assertThrows(EncoderException.class, () -> bCodec.encode(input));
        assertEquals("Objects of type " + input.getClass().getName() + " cannot be encoded using BCodec", exception.getMessage());
    }
}
