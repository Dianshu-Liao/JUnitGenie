package org.apache.commons.codec.net;

import org.apache.commons.codec.net.QuotedPrintableCodec;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

class QuotedPrintableCodec_encodeByte_1_0_Test {

    private QuotedPrintableCodec codec;

    @BeforeEach
    void setUp() {
        codec = new QuotedPrintableCodec();
    }

    @Test
    void testEncodeByte_WhenEncodeTrue_ShouldReturnEncodedValue() throws Exception {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        // ASCII for 'A'
        int inputByte = 65;
        boolean encode = true;
        // Use reflection to call the private method
        Method method = QuotedPrintableCodec.class.getDeclaredMethod("encodeByte", int.class, boolean.class, ByteArrayOutputStream.class);
        method.setAccessible(true);
        // Invoke the method
        int result = (int) method.invoke(codec, inputByte, encode, buffer);
        // Check the result
        assertEquals(3, result);
        assertEquals("=41", buffer.toString("UTF-8"));
    }

    @Test
    void testEncodeByte_WhenEncodeFalse_ShouldReturnByteValue() throws Exception {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        // ASCII for 'A'
        int inputByte = 65;
        boolean encode = false;
        // Use reflection to call the private method
        Method method = QuotedPrintableCodec.class.getDeclaredMethod("encodeByte", int.class, boolean.class, ByteArrayOutputStream.class);
        method.setAccessible(true);
        // Invoke the method
        int result = (int) method.invoke(codec, inputByte, encode, buffer);
        // Check the result
        assertEquals(1, result);
        assertEquals("A", buffer.toString("UTF-8"));
    }

    @Test
    void testEncodeByte_WhenInputByteIsNonPrintable_ShouldReturnEncodedValue() throws Exception {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        // TAB character
        int inputByte = 9;
        boolean encode = true;
        // Use reflection to call the private method
        Method method = QuotedPrintableCodec.class.getDeclaredMethod("encodeByte", int.class, boolean.class, ByteArrayOutputStream.class);
        method.setAccessible(true);
        // Invoke the method
        int result = (int) method.invoke(codec, inputByte, encode, buffer);
        // Check the result
        assertEquals(3, result);
        assertEquals("=09", buffer.toString("UTF-8"));
    }

    @Test
    void testEncodeByte_WhenInputByteIsPrintable_ShouldReturnByteValue() throws Exception {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        // SPACE character
        int inputByte = 32;
        boolean encode = false;
        // Use reflection to call the private method
        Method method = QuotedPrintableCodec.class.getDeclaredMethod("encodeByte", int.class, boolean.class, ByteArrayOutputStream.class);
        method.setAccessible(true);
        // Invoke the method
        int result = (int) method.invoke(codec, inputByte, encode, buffer);
        // Check the result
        assertEquals(1, result);
        assertEquals(" ", buffer.toString("UTF-8"));
    }
}
