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
import java.util.BitSet;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;

public class QCodec_encode_4_0_Test {

    @Test
    public void testEncode_NullInput() throws EncoderException {
        QCodec codec = new QCodec();
        Object result = codec.encode(null);
        assertNull(result, "Encoding null should return null");
    }

    @Test
    public void testEncode_ValidString() throws EncoderException {
        QCodec codec = new QCodec();
        String input = "Hello World";
        // Assuming the encode method simply returns the input for this example
        String expectedOutput = "Hello World";
        Object result = codec.encode(input);
        assertEquals(expectedOutput, result, "Encoding a valid string should return the encoded string");
    }

    @Test
    public void testEncode_InvalidObjectType() {
        QCodec codec = new QCodec();
        Object invalidInput = new Object();
        EncoderException thrown = assertThrows(EncoderException.class, () -> {
            codec.encode(invalidInput);
        });
        assertEquals("Objects of type " + invalidInput.getClass().getName() + " cannot be encoded using Q codec", thrown.getMessage());
    }
}
