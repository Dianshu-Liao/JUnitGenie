// Test method
package org.apache.commons.codec.net;

import org.apache.commons.codec.binary.Base64;
import java.lang.reflect.Method;
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
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.BaseNCodec;

class BCodec_doEncoding_3_0_Test {

    @Test
    void testDoEncoding_NullInput() throws Exception {
        BCodec bCodec = new BCodec();
        byte[] result = invokeDoEncoding(bCodec, null);
        assertNull(result, "Expected null output for null input.");
    }

    @Test
    void testDoEncoding_EmptyInput() throws Exception {
        BCodec bCodec = new BCodec();
        byte[] result = invokeDoEncoding(bCodec, new byte[0]);
        assertArrayEquals(Base64.encodeBase64(new byte[0]), result, "Expected Base64 encoding of empty array.");
    }

    @Test
    void testDoEncoding_ValidInput() throws Exception {
        BCodec bCodec = new BCodec();
        byte[] input = "Hello".getBytes();
        byte[] expectedOutput = Base64.encodeBase64(input);
        byte[] result = invokeDoEncoding(bCodec, input);
        assertArrayEquals(expectedOutput, result, "Expected Base64 encoding of the input byte array.");
    }

    private byte[] invokeDoEncoding(BCodec bCodec, byte[] bytes) throws Exception {
        Method method = BCodec.class.getDeclaredMethod("doEncoding", byte[].class);
        method.setAccessible(true);
        return (byte[]) method.invoke(bCodec, (Object) bytes);
    }
}
