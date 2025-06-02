package org.apache.commons.codec.net;

import org.apache.commons.codec.EncoderException;
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
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class QuotedPrintableCodec_encode_13_0_Test {

    private QuotedPrintableCodec codec;

    @BeforeEach
    public void setUp() {
        codec = new QuotedPrintableCodec();
    }

    @Test
    public void testEncode_NullObject() throws Exception {
        assertNull(invokeEncodeMethod(null));
    }

    @Test
    public void testEncode_ByteArray() throws Exception {
        byte[] input = "Hello World".getBytes(StandardCharsets.UTF_8);
        byte[] encoded = (byte[]) invokeEncodeMethod(input);
        assertNotNull(encoded);
        // Additional assertions can be made based on the expected output
    }

    @Test
    public void testEncode_String() throws Exception {
        String input = "Hello World";
        String encoded = (String) invokeEncodeMethod(input);
        assertNotNull(encoded);
        // Additional assertions can be made based on the expected output
    }

    @Test
    public void testEncode_InvalidType() {
        Exception exception = assertThrows(EncoderException.class, () -> {
            invokeEncodeMethod(123);
        });
        assertEquals("Objects of type java.lang.Integer cannot be quoted-printable encoded", exception.getMessage());
    }

    private Object invokeEncodeMethod(Object obj) throws Exception {
        Method encodeMethod = QuotedPrintableCodec.class.getDeclaredMethod("encode", Object.class);
        encodeMethod.setAccessible(true);
        return encodeMethod.invoke(codec, obj);
    }
}
