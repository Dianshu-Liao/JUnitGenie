package org.apache.commons.codec.net;

import java.nio.charset.StandardCharsets;
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
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class QuotedPrintableCodec_encode_12_0_Test {

    private QuotedPrintableCodec codec;

    @BeforeEach
    public void setUp() {
        codec = new QuotedPrintableCodec(StandardCharsets.UTF_8, false);
    }

    @Test
    public void testEncodeWithPrintableCharacters() {
        byte[] input = "Hello World!".getBytes(StandardCharsets.UTF_8);
        byte[] expected = "Hello World!".getBytes(StandardCharsets.UTF_8);
        byte[] result = codec.encode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeWithSpecialCharacters() {
        byte[] input = "Hello \u00A9 World!".getBytes(StandardCharsets.UTF_8);
        byte[] expected = "Hello =C2=A9 World!".getBytes(StandardCharsets.UTF_8);
        byte[] result = codec.encode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeWithLineBreaks() {
        byte[] input = "Hello\nWorld!".getBytes(StandardCharsets.UTF_8);
        byte[] expected = "Hello=0AWorld!".getBytes(StandardCharsets.UTF_8);
        byte[] result = codec.encode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeWithLongInput() {
        byte[] input = "This is a long string that exceeds the safe length of 73 bytes, and should be encoded properly.".getBytes(StandardCharsets.UTF_8);
        byte[] result = codec.encode(input);
        // You can implement a specific expected result based on the encoding logic
        assertNotNull(result);
    }

    @Test
    public void testEncodeWithEmptyInput() {
        byte[] input = new byte[0];
        byte[] expected = new byte[0];
        byte[] result = codec.encode(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeWithNullInput() {
        assertThrows(NullPointerException.class, () -> {
            // Fixed the buggy line by specifying the type
            codec.encode((byte[]) null);
        });
    }
}
