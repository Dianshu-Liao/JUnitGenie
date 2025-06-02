package org.apache.commons.codec.net;

import java.nio.charset.Charset;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.BaseNCodec;

public class BCodec_doDecoding_2_0_Test {

    private BCodec bCodec;

    @BeforeEach
    public void setUp() {
        bCodec = new BCodec();
    }

    @Test
    public void testDoDecoding_NullInput() {
        byte[] result = invokeDoDecoding(null);
        assertNull(result, "Expected null output for null input");
    }

    @Test
    public void testDoDecoding_ValidInput() {
        // "Hello World" in Base64
        String input = "SGVsbG8gV29ybGQ=";
        byte[] result = invokeDoDecoding(input.getBytes(Charset.defaultCharset()));
        assertArrayEquals("Hello World".getBytes(Charset.defaultCharset()), result, "Decoded bytes do not match expected");
    }

    @Test
    public void testDoDecoding_EmptyInput() {
        byte[] result = invokeDoDecoding(new byte[0]);
        assertArrayEquals(new byte[0], result, "Expected empty output for empty input");
    }

    private byte[] invokeDoDecoding(byte[] bytes) {
        try {
            java.lang.reflect.Method method = BCodec.class.getDeclaredMethod("doDecoding", byte[].class);
            method.setAccessible(true);
            return (byte[]) method.invoke(bCodec, (Object) bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
