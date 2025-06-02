package org.apache.commons.codec.net;

import org.apache.commons.codec.EncoderException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.BaseNCodec;

public class BCodec_encode_6_0_Test {

    private BCodec bCodec;

    @BeforeEach
    public void setUp() {
        bCodec = new BCodec();
    }

    @Test
    public void testEncode_ValidInput() {
        String input = "Hello, World!";
        Charset charset = StandardCharsets.UTF_8;
        try {
            String expectedOutput = encodeText(input, charset);
            String result = bCodec.encode(input, charset);
            assertEquals(expectedOutput, result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test
    public void testEncode_EmptyString() {
        String input = "";
        Charset charset = StandardCharsets.UTF_8;
        try {
            String expectedOutput = encodeText(input, charset);
            String result = bCodec.encode(input, charset);
            assertEquals(expectedOutput, result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test
    public void testEncode_NullInput() {
        Charset charset = StandardCharsets.UTF_8;
        assertThrows(EncoderException.class, () -> {
            bCodec.encode(null, charset);
        });
    }

    @Test
    public void testEncode_UnsupportedCharset() {
        String input = "Hello, World!";
        Charset charset = Charset.forName("unsupported-charset");
        assertThrows(EncoderException.class, () -> {
            bCodec.encode(input, charset);
        });
    }

    // Helper method to invoke the private method encodeText using reflection
    private String encodeText(String strSource, Charset sourceCharset) throws Exception {
        Method method = BCodec.class.getDeclaredMethod("encodeText", String.class, Charset.class);
        method.setAccessible(true);
        return (String) method.invoke(bCodec, strSource, sourceCharset);
    }
}
