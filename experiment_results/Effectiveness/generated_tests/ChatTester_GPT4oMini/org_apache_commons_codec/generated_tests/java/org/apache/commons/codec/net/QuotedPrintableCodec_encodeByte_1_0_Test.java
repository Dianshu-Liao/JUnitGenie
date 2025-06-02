package org.apache.commons.codec.net;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
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

    private QuotedPrintableCodec codec;

    @BeforeEach
    public void setUp() {
        codec = new QuotedPrintableCodec();
    }

    @Test
    public void testEncodeByte_WhenEncodeTrue_ShouldReturnEncodedByte() throws Exception {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        // ASCII 'A'
        int byteToEncode = 65;
        // Use reflection to invoke the private method
        Method encodeByteMethod = QuotedPrintableCodec.class.getDeclaredMethod("encodeByte", int.class, boolean.class, ByteArrayOutputStream.class);
        encodeByteMethod.setAccessible(true);
        // Invoke the method
        int result = (int) encodeByteMethod.invoke(codec, byteToEncode, true, buffer);
        // Check the buffer and result
        // Assuming encodeQuotedPrintable encodes 'A' to "=41"
        byte[] expectedOutput = new byte[] { '=', 'A' };
        assertEquals(2, result);
        assertEquals(expectedOutput, buffer.toByteArray());
    }

    @Test
    public void testEncodeByte_WhenEncodeFalse_ShouldReturnWrittenByte() throws Exception {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        // ASCII 'A'
        int byteToWrite = 65;
        // Use reflection to invoke the private method
        Method encodeByteMethod = QuotedPrintableCodec.class.getDeclaredMethod("encodeByte", int.class, boolean.class, ByteArrayOutputStream.class);
        encodeByteMethod.setAccessible(true);
        // Invoke the method
        int result = (int) encodeByteMethod.invoke(codec, byteToWrite, false, buffer);
        // Check the buffer and result
        assertEquals(1, result);
        assertEquals(byteToWrite, buffer.toByteArray()[0]);
    }

    @Test
    public void testEncodeByte_WhenBufferNull_ShouldThrowException() throws Exception {
        // ASCII 'A'
        int byteToWrite = 65;
        // Use reflection to invoke the private method
        Method encodeByteMethod = QuotedPrintableCodec.class.getDeclaredMethod("encodeByte", int.class, boolean.class, ByteArrayOutputStream.class);
        encodeByteMethod.setAccessible(true);
        // Expect an exception when buffer is null
        assertThrows(NullPointerException.class, () -> {
            encodeByteMethod.invoke(codec, byteToWrite, true, null);
        });
    }
}
