package org.apache.commons.codec.net;

import java.io.ByteArrayOutputStream;
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

public class QuotedPrintableCodec_encodeByte_1_4_Test {

    private static class QuotedPrintableCodecTestable extends QuotedPrintableCodec {

        public QuotedPrintableCodecTestable() {
            super();
        }

        public int testEncodeByte(int b, boolean encode, ByteArrayOutputStream buffer) {
            try {
                java.lang.reflect.Method method = QuotedPrintableCodec.class.getDeclaredMethod("encodeByte", int.class, boolean.class, ByteArrayOutputStream.class);
                method.setAccessible(true);
                return (int) method.invoke(null, b, encode, buffer);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void testEncodeByte_WithEncodeTrue() {
        QuotedPrintableCodecTestable codec = new QuotedPrintableCodecTestable();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        // ASCII for 'A'
        int inputByte = 65;
        boolean encode = true;
        int result = codec.testEncodeByte(inputByte, encode, buffer);
        assertEquals(3, result);
        assertEquals("=41", buffer.toString());
    }

    @Test
    public void testEncodeByte_WithEncodeFalse() {
        QuotedPrintableCodecTestable codec = new QuotedPrintableCodecTestable();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        // ASCII for 'B'
        int inputByte = 66;
        boolean encode = false;
        int result = codec.testEncodeByte(inputByte, encode, buffer);
        assertEquals(1, result);
        assertEquals("B", buffer.toString());
    }

    @Test
    public void testEncodeByte_WithSpecialCharacter() {
        QuotedPrintableCodecTestable codec = new QuotedPrintableCodecTestable();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        // ASCII for SPACE
        int inputByte = 32;
        boolean encode = true;
        int result = codec.testEncodeByte(inputByte, encode, buffer);
        assertEquals(3, result);
        assertEquals("=20", buffer.toString());
    }

    @Test
    public void testEncodeByte_WithControlCharacter() {
        QuotedPrintableCodecTestable codec = new QuotedPrintableCodecTestable();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        // ASCII for TAB
        int inputByte = 9;
        boolean encode = true;
        int result = codec.testEncodeByte(inputByte, encode, buffer);
        assertEquals(3, result);
        assertEquals("=09", buffer.toString());
    }

    @Test
    public void testEncodeByte_WithNonPrintableCharacter() {
        QuotedPrintableCodecTestable codec = new QuotedPrintableCodecTestable();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        // Non-printable character
        int inputByte = 255;
        boolean encode = true;
        int result = codec.testEncodeByte(inputByte, encode, buffer);
        assertEquals(3, result);
        assertEquals("=FF", buffer.toString());
    }
}
