package org.apache.commons.codec.net;

import org.apache.commons.codec.EncoderException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class URLCodec_encode_8_1_Test {

    @Test
    public void testEncode_NullString() throws EncoderException {
        URLCodec codec = new URLCodec();
        String result = codec.encode((String) null);
        assertNull(result, "Encoding null should return null");
    }

    @Test
    public void testEncode_EmptyString() throws EncoderException {
        URLCodec codec = new URLCodec();
        String result = codec.encode("");
        assertEquals("", result, "Encoding empty string should return empty string");
    }

    @Test
    public void testEncode_SimpleString() throws EncoderException {
        URLCodec codec = new URLCodec();
        String result = codec.encode("Hello World");
        assertEquals("Hello%20World", result, "Encoding 'Hello World' should return 'Hello%20World'");
    }

    @Test
    public void testEncode_SpecialCharacters() throws EncoderException {
        URLCodec codec = new URLCodec();
        String result = codec.encode("!@#$%^&*()");
        assertEquals("%21%40%23%24%25%5E%26%2A%28%29", result, "Encoding '!@#$%^&*()' should return '%21%40%23%24%25%5E%26%2A%28%29'");
    }

    @Test
    public void testEncode_UnicodeCharacters() throws EncoderException {
        URLCodec codec = new URLCodec();
        String result = codec.encode("こんにちは");
        assertEquals("%E3%81%93%E3%82%93%E3%81%AB%E3%81%A1%E3%81%AF", result, "Encoding 'こんにちは' should return '%E3%81%93%E3%82%93%E3%81%AB%E3%81%A1%E3%81%AF'");
    }

    @Test
    public void testEncode_Spaces() throws EncoderException {
        URLCodec codec = new URLCodec();
        String result = codec.encode("This is a test");
        assertEquals("This%20is%20a%20test", result, "Encoding 'This is a test' should return 'This%20is%20a%20test'");
    }

    @Test
    public void testEncode_ReservedCharacters() throws EncoderException {
        URLCodec codec = new URLCodec();
        String result = codec.encode(":/?#[]@!$&'()*+,;=");
        assertEquals("%3A%2F%3F%23%5B%5D%40%21%24%26%27%28%29%2A%2B%2C%3B%3D", result, "Encoding ':/?#[]@!$&'()*+,;=' should return '%3A%2F%3F%23%5B%5D%40%21%24%26%27%28%29%2A%2B%2C%3B%3D'");
    }
}
