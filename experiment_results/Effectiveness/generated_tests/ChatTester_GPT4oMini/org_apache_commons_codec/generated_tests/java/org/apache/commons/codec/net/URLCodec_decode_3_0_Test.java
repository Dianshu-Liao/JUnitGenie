package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class URLCodec_decode_3_0_Test {

    private URLCodec urlCodec;

    @BeforeEach
    public void setUp() {
        urlCodec = new URLCodec();
    }

    @Test
    public void testDecode_NullObject() throws DecoderException {
        // Fixed the buggy line by casting null to String
        Object result = urlCodec.decode((String) null);
        assertNull(result);
    }

    @Test
    public void testDecode_ByteArray() throws DecoderException {
        // Represents "%ab"
        byte[] input = new byte[] { 37, 97, 98 };
        Object result = urlCodec.decode(input);
        assertNotNull(result);
        assertTrue(result instanceof String);
        assertEquals("%ab", result);
    }

    @Test
    public void testDecode_String() throws DecoderException {
        // Represents a space
        String input = "%20";
        Object result = urlCodec.decode(input);
        assertNotNull(result);
        assertTrue(result instanceof String);
        assertEquals(" ", result);
    }

    @Test
    public void testDecode_InvalidObject() {
        Exception exception = assertThrows(DecoderException.class, () -> {
            urlCodec.decode(new Integer(1));
        });
        assertEquals("Objects of type java.lang.Integer cannot be URL decoded", exception.getMessage());
    }
}
