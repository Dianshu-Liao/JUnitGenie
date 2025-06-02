package org.apache.commons.codec.net;

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.EncoderException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class URLCodec_encode_7_2_Test {

    private URLCodec urlCodec;

    @BeforeEach
    public void setUp() {
        // Create an instance of URLCodec
        urlCodec = new URLCodec();
    }

    @Test
    public void testEncodeByteArray_ValidInput() throws EncoderException {
        byte[] input = "Hello".getBytes();
        // Expected URL encoded output
        byte[] expected = "%48%65%6C%6C%6F".getBytes();
        byte[] actual = urlCodec.encode(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testEncodeString_ValidInput() throws EncoderException {
        String input = "Hello World";
        // Expected URL encoded output
        String expected = "Hello%20World";
        String actual = urlCodec.encode(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testEncodeNullInput() throws EncoderException {
        Object input = null;
        Object actual = urlCodec.encode(input);
        // Expecting null for null input
        assertNull(actual);
    }

    @Test
    public void testEncodeInvalidType() {
        Exception exception = assertThrows(EncoderException.class, () -> {
            // Passing an invalid type
            urlCodec.encode(new Integer(123));
        });
        assertEquals("Objects of type java.lang.Integer cannot be URL encoded", exception.getMessage());
    }
}
