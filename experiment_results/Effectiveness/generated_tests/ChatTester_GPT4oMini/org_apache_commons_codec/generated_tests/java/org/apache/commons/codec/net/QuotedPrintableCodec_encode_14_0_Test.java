package org.apache.commons.codec.net;

import java.nio.charset.Charset;
import org.apache.commons.codec.EncoderException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class QuotedPrintableCodec_encode_14_0_Test {

    private QuotedPrintableCodec codec;

    @BeforeEach
    public void setUp() {
        codec = new QuotedPrintableCodec();
    }

    @Test
    public void testEncodeWithValidInput() throws Exception {
        String input = "Hello World!";
        // Assuming this is the expected encoded output
        String expectedOutput = "Hello=20World!";
        String actualOutput = invokeEncode(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEncodeWithEmptyInput() throws Exception {
        String input = "";
        // Assuming encoding empty string returns empty string
        String expectedOutput = "";
        String actualOutput = invokeEncode(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEncodeWithSpecialCharacters() throws Exception {
        String input = "Hello, =World!";
        // Assuming this is the expected encoded output
        String expectedOutput = "Hello,=20=3DWorld!";
        String actualOutput = invokeEncode(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testEncodeWithNullInput() {
        assertThrows(EncoderException.class, () -> {
            invokeEncode(null);
        });
    }

    private String invokeEncode(String sourceStr) throws Exception {
        Method method = QuotedPrintableCodec.class.getDeclaredMethod("encode", String.class);
        method.setAccessible(true);
        return (String) method.invoke(codec, sourceStr);
    }
}
