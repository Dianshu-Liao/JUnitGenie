package org.apache.commons.codec.net;

import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.QuotedPrintableCodec;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class QuotedPrintableCodec_encode_13_1_Test {

    private QuotedPrintableCodec codec;

    @BeforeEach
    public void setUp() {
        codec = new QuotedPrintableCodec();
    }

    @Test
    public void testEncode_NullInput() throws Exception {
        Object result = invokeEncodeMethod(null);
        assertEquals(null, result);
    }

    @Test
    public void testEncode_ByteArrayInput() throws Exception {
        byte[] input = "Hello World".getBytes(StandardCharsets.UTF_8);
        byte[] expected = codec.encode(input);
        byte[] result = (byte[]) invokeEncodeMethod(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncode_StringInput() throws Exception {
        String input = "Hello World";
        String expected = codec.encode(input);
        String result = (String) invokeEncodeMethod(input);
        assertEquals(expected, result);
    }

    @Test
    public void testEncode_InvalidTypeInput() {
        assertThrows(EncoderException.class, () -> {
            invokeEncodeMethod(123);
        });
    }

    @Test
    public void testEncode_EmptyStringInput() throws Exception {
        String input = "";
        String expected = codec.encode(input);
        String result = (String) invokeEncodeMethod(input);
        assertEquals(expected, result);
    }

    @Test
    public void testEncode_ByteArrayEmptyInput() throws Exception {
        byte[] input = new byte[0];
        byte[] expected = codec.encode(input);
        byte[] result = (byte[]) invokeEncodeMethod(input);
        assertArrayEquals(expected, result);
    }

    private Object invokeEncodeMethod(Object input) throws Exception {
        Method method = QuotedPrintableCodec.class.getDeclaredMethod("encode", Object.class);
        method.setAccessible(true);
        return method.invoke(codec, input);
    }
}
