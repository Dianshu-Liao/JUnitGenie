package org.apache.commons.codec.net;

import org.apache.commons.codec.EncoderException;
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
        bCodec = new BCodec();
    }

    @Test
    public void testEncode_NullValue() throws EncoderException {
        Object result = bCodec.encode(null);
        assertNull(result, "Encoding null should return null");
    }

    @Test
    public void testEncode_StringValue() throws EncoderException {
        String input = "test";
        Object result = bCodec.encode(input);
        assertEquals(input, result, "Encoding a string should return the same string");
    }

    @Test
    public void testEncode_NonStringValue() {
        Object input = new Object();
        EncoderException thrown = assertThrows(EncoderException.class, () -> {
            bCodec.encode(input);
        }, "Encoding a non-string object should throw EncoderException");
        assertEquals("Objects of type java.lang.Object cannot be encoded using BCodec", thrown.getMessage());
    }
}
