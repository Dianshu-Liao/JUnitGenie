package org.apache.commons.codec.net;

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
import java.util.BitSet;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;

class QCodec_encode_4_0_Test {

    @Test
    void testEncode_NullInput() throws EncoderException {
        QCodec codec = new QCodec();
        assertNull(codec.encode(null), "Encoding null should return null");
    }

    @Test
    void testEncode_StringInput() throws EncoderException {
        QCodec codec = new QCodec();
        String input = "Hello World";
        Object result = codec.encode(input);
        assertNotNull(result);
        // Assuming encode simply returns the input for this test
        assertEquals(input, result);
    }

    @Test
    void testEncode_NonStringInput() {
        QCodec codec = new QCodec();
        Exception exception = assertThrows(EncoderException.class, () -> {
            // Integer is not a valid type for encoding
            codec.encode(123);
        });
        assertEquals("Objects of type java.lang.Integer cannot be encoded using Q codec", exception.getMessage());
    }
}
