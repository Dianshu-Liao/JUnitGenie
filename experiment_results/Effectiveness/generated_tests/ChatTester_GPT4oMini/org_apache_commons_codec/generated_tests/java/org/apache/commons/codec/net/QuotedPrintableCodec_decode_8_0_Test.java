// Test method
package org.apache.commons.codec.net;

import java.nio.charset.Charset;
import org.apache.commons.codec.DecoderException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class QuotedPrintableCodec_decode_8_0_Test {

    private QuotedPrintableCodec codec;

    @BeforeEach
    public void setUp() {
        codec = new QuotedPrintableCodec();
    }

    @Test
    public void testDecodeWithNull() throws DecoderException {
        // Fixed ambiguous reference by casting to String
        assertNull(codec.decode((String) null));
    }

    @Test
    public void testDecodeWithByteArray() throws DecoderException {
        byte[] input = "Hello World".getBytes();
        Object result = codec.decode(input);
        assertArrayEquals(input, (byte[]) result);
    }

    @Test
    public void testDecodeWithString() throws DecoderException {
        String input = "Hello World";
        Object result = codec.decode(input);
        assertEquals(input, result);
    }

    @Test
    public void testDecodeWithInvalidType() {
        Object input = new Object();
        DecoderException exception = assertThrows(DecoderException.class, () -> {
            codec.decode(input);
        });
        assertEquals("Objects of type " + input.getClass().getName() + " cannot be quoted-printable decoded", exception.getMessage());
    }
}
