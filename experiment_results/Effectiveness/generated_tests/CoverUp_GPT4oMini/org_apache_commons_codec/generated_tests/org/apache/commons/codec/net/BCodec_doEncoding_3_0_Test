package org.apache.commons.codec.net;

import org.apache.commons.codec.CodecPolicy;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.BaseNCodec;

class BCodec_doEncoding_3_0_Test {

    private final BCodec bCodec = new BCodec();

    @Test
    void testDoEncoding_NullInput() throws Exception {
        byte[] result = invokeDoEncoding(null);
        assertNull(result, "Encoding null should return null.");
    }

    @Test
    void testDoEncoding_EmptyInput() throws Exception {
        byte[] result = invokeDoEncoding(new byte[0]);
        assertArrayEquals(new byte[] {}, result, "Encoding empty byte array should return empty byte array.");
    }

    @Test
    void testDoEncoding_SingleByteInput() throws Exception {
        byte[] input = new byte[] { 1 };
        byte[] result = invokeDoEncoding(input);
        assertArrayEquals(new byte[] { 'A', '=', '=' }, result, "Encoding single byte should return correct base64 representation.");
    }

    @Test
    void testDoEncoding_MultipleBytesInput() throws Exception {
        byte[] input = new byte[] { 1, 2, 3 };
        byte[] result = invokeDoEncoding(input);
        assertArrayEquals(new byte[] { 'A', 'Q', 'I', '=' }, result, "Encoding multiple bytes should return correct base64 representation.");
    }

    private byte[] invokeDoEncoding(byte[] bytes) throws Exception {
        Method method = BCodec.class.getDeclaredMethod("doEncoding", byte[].class);
        method.setAccessible(true);
        return (byte[]) method.invoke(bCodec, (Object) bytes);
    }
}
