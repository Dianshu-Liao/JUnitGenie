package org.apache.commons.codec.net;

import org.junit.jupiter.api.function.Executable;
import java.nio.charset.Charset;
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
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

class QuotedPrintableCodec_decode_7_0_Test {

    private QuotedPrintableCodec codec;

    @BeforeEach
    void setUp() {
        codec = new QuotedPrintableCodec();
    }

    @Test
    void testDecodeValidInput() throws DecoderException {
        byte[] input = "Hello=20World".getBytes();
        byte[] expectedOutput = "Hello World".getBytes();
        byte[] actualOutput = codec.decode(input);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    void testDecodeEmptyInput() throws DecoderException {
        byte[] input = "".getBytes();
        byte[] expectedOutput = "".getBytes();
        byte[] actualOutput = codec.decode(input);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    void testDecodeInvalidInput() {
        byte[] input = "Invalid=XX".getBytes();
        Executable executable = () -> codec.decode(input);
        assertThrows(DecoderException.class, executable);
    }

    @Test
    void testDecodeWithSpecialCharacters() throws DecoderException {
        byte[] input = "Quoted=20Printable=0ACodec".getBytes();
        byte[] expectedOutput = "Quoted Printable\nCodec".getBytes();
        byte[] actualOutput = codec.decode(input);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    void testDecodeWithLineBreaks() throws DecoderException {
        byte[] input = "Line1=0ALine2=0ALine3".getBytes();
        byte[] expectedOutput = "Line1\nLine2\nLine3".getBytes();
        byte[] actualOutput = codec.decode(input);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    void testDecodeWithMultipleEscapes() throws DecoderException {
        byte[] input = "This=20is=20a=20test=0Awith=20multiple=20escapes".getBytes();
        byte[] expectedOutput = "This is a test\nwith multiple escapes".getBytes();
        byte[] actualOutput = codec.decode(input);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    void testDecodeWithSpacesAndTabs() throws DecoderException {
        byte[] input = "Space=20and=09tab".getBytes();
        byte[] expectedOutput = "Space and\ttab".getBytes();
        byte[] actualOutput = codec.decode(input);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    void testDecodeWithOnlyEscapedChars() throws DecoderException {
        byte[] input = "=20=0A=09".getBytes();
        byte[] expectedOutput = " \n\t".getBytes();
        byte[] actualOutput = codec.decode(input);
        assertArrayEquals(expectedOutput, actualOutput);
    }
}
