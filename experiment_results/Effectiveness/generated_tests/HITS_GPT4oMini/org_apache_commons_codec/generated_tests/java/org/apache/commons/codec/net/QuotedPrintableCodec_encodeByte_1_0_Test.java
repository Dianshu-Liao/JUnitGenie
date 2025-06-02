package org.apache.commons.codec.net;

import java.io.ByteArrayOutputStream;
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

public class QuotedPrintableCodec_encodeByte_1_0_Test {

    private static class TestableQuotedPrintableCodec extends QuotedPrintableCodec {

        public TestableQuotedPrintableCodec() {
            super();
        }

        public int encodeBytePublic(int b, boolean encode, ByteArrayOutputStream buffer) throws Exception {
            Method method = QuotedPrintableCodec.class.getDeclaredMethod("encodeByte", int.class, boolean.class, ByteArrayOutputStream.class);
            method.setAccessible(true);
            return (int) method.invoke(null, b, encode, buffer);
        }
    }

    @Test
    public void testEncodeByte_WhenEncodeIsTrue_ShouldReturnEncodedByte() throws Exception {
        // Arrange
        TestableQuotedPrintableCodec codec = new TestableQuotedPrintableCodec();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        // ASCII for 'A'
        int inputByte = 65;
        boolean encode = true;
        // Act
        int result = codec.encodeBytePublic(inputByte, encode, buffer);
        // Assert
        assertEquals(3, result);
        assertEquals("=41", buffer.toString());
    }

    @Test
    public void testEncodeByte_WhenEncodeIsFalse_ShouldReturnWrittenByte() throws Exception {
        // Arrange
        TestableQuotedPrintableCodec codec = new TestableQuotedPrintableCodec();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        // ASCII for 'A'
        int inputByte = 65;
        boolean encode = false;
        // Act
        int result = codec.encodeBytePublic(inputByte, encode, buffer);
        // Assert
        assertEquals(1, result);
        assertEquals("A", buffer.toString());
    }
}
