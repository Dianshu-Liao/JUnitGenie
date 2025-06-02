package org.apache.commons.codec.net;

import org.apache.commons.codec.EncoderException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class URLCodec_encode_7_0_Test {

    private final URLCodec urlCodec = new URLCodec();

    @Test
    public void testEncode_NullObject() throws EncoderException {
        assertNull(urlCodec.encode((String) null));
    }

    @Test
    public void testEncode_ByteArray() throws EncoderException {
        byte[] input = "test".getBytes();
        Object result = urlCodec.encode(input);
        assertNotNull(result);
        assertTrue(result instanceof byte[]);
        assertArrayEquals(input, (byte[]) result);
    }

    @Test
    public void testEncode_String() throws EncoderException {
        String input = "test string";
        Object result = urlCodec.encode(input);
        assertNotNull(result);
        assertTrue(result instanceof String);
        assertEquals(input, result);
    }

    @Test
    public void testEncode_InvalidObject() {
        Exception exception = assertThrows(EncoderException.class, () -> {
            urlCodec.encode(123);
        });
        assertEquals("Objects of type java.lang.Integer cannot be URL encoded", exception.getMessage());
    }
}
