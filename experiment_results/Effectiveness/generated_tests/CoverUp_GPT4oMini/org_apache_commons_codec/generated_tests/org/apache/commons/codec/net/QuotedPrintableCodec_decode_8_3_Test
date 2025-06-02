package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.QuotedPrintableCodec;
import java.nio.charset.StandardCharsets;
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
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class QuotedPrintableCodec_decode_8_3_Test {

    private QuotedPrintableCodec codec;

    @BeforeEach
    public void setUp() {
        codec = new QuotedPrintableCodec();
    }

    @Test
    public void testDecode_NullInput() throws Exception {
        assertNull(invokeDecodeMethod(null));
    }

    @Test
    public void testDecode_ByteArrayInput() throws Exception {
        byte[] input = "Hello World".getBytes(StandardCharsets.UTF_8);
        byte[] decoded = (byte[]) invokeDecodeMethod(input);
        assertArrayEquals(input, decoded);
    }

    @Test
    public void testDecode_StringInput() throws Exception {
        String input = "Hello World";
        String decoded = (String) invokeDecodeMethod(input);
        assertEquals(input, decoded);
    }

    @Test
    public void testDecode_InvalidType() {
        Exception exception = assertThrows(DecoderException.class, () -> {
            invokeDecodeMethod(123);
        });
        assertEquals("Objects of type java.lang.Integer cannot be quoted-printable decoded", exception.getMessage());
    }

    @Test
    public void testDecode_EmptyString() throws Exception {
        String input = "";
        String decoded = (String) invokeDecodeMethod(input);
        assertEquals(input, decoded);
    }

    @Test
    public void testDecode_ByteArrayWithPrintableCharacters() throws Exception {
        byte[] input = "Quoted-Printable=20Codec".getBytes(StandardCharsets.UTF_8);
        byte[] decoded = (byte[]) invokeDecodeMethod(input);
        assertArrayEquals(input, decoded);
    }

    @Test
    public void testDecode_ByteArrayWithSpecialCharacters() throws Exception {
        byte[] input = "Hello=20World".getBytes(StandardCharsets.UTF_8);
        byte[] decoded = (byte[]) invokeDecodeMethod(input);
        assertEquals("Hello World", new String(decoded, StandardCharsets.UTF_8));
    }

    private Object invokeDecodeMethod(Object obj) throws Exception {
        Method method = QuotedPrintableCodec.class.getDeclaredMethod("decode", Object.class);
        method.setAccessible(true);
        return method.invoke(codec, obj);
    }
}
