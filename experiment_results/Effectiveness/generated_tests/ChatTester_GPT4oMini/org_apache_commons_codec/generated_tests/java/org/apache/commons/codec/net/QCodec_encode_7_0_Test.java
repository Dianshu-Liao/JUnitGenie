// Test method
package org.apache.commons.codec.net;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.BitSet;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class QCodec_encode_7_0_Test {

    private QCodec qCodec;

    @BeforeEach
    public void setUp() {
        qCodec = new QCodec();
    }

    @Test
    public void testEncode_ValidInput() throws EncoderException {
        String sourceStr = "Hello World";
        String sourceCharset = "UTF-8";
        // Mock the encodeText method to return a specific encoded string
        // Example expected output
        String expectedEncodedStr = "Hello+World";
        QCodec spyQCodec = spy(qCodec);
        doReturn(expectedEncodedStr).when(spyQCodec).encodeText(sourceStr, sourceCharset);
        String result = spyQCodec.encode(sourceStr, sourceCharset);
        assertNotNull(result);
        assertEquals(expectedEncodedStr, result);
    }

    @Test
    public void testEncode_UnsupportedCharset() {
        String sourceStr = "Hello World";
        String sourceCharset = "INVALID_CHARSET";
        EncoderException exception = assertThrows(EncoderException.class, () -> {
            qCodec.encode(sourceStr, sourceCharset);
        });
        assertTrue(exception.getCause() instanceof UnsupportedCharsetException);
    }

    @Test
    public void testEncode_NullSourceStr() throws EncoderException {
        String sourceCharset = "UTF-8";
        String result = qCodec.encode(null, sourceCharset);
        // Assuming null input should return null
        assertNull(result);
    }

    @Test
    public void testEncode_NullSourceCharset() {
        String sourceStr = "Hello World";
        EncoderException exception = assertThrows(EncoderException.class, () -> {
            // Fixed the ambiguous method reference by using Charset.forName
            qCodec.encode(sourceStr, (Charset) null);
        });
        // Assuming null charset should throw exception
        assertNotNull(exception);
    }
}
