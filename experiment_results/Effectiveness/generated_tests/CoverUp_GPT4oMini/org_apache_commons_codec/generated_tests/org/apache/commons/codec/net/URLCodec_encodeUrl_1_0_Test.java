package org.apache.commons.codec.net;

import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.codec.net.Utils;
import java.util.BitSet;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class URLCodec_encodeUrl_1_0_Test {

    @Test
    public void testEncodeUrl_WithNullBytes_ReturnsNull() {
        // Arrange
        URLCodec urlCodec = new URLCodec();
        BitSet urlsafe = new BitSet();
        // Act
        byte[] result = URLCodec.encodeUrl(urlsafe, null);
        // Assert
        assertNull(result);
    }

    @Test
    public void testEncodeUrl_WithNullUrlSafe_UsesDefault() {
        // Arrange
        URLCodec urlCodec = new URLCodec();
        byte[] input = "hello world".getBytes();
        // Act
        byte[] result = URLCodec.encodeUrl(null, input);
        // Assert
        // The expected output will depend on the default values of WWW_FORM_URL_SAFE.
        // For the sake of this example, we will assume it allows space as '+'.
        // This is a simplified assumption.
        byte[] expected = "hello+world".getBytes();
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeUrl_WithCustomUrlSafe_EncodesCorrectly() {
        // Arrange
        URLCodec urlCodec = new URLCodec();
        BitSet urlsafe = new BitSet();
        // Allow 'h'
        urlsafe.set('h');
        // Allow 'e'
        urlsafe.set('e');
        // Allow 'l'
        urlsafe.set('l');
        // Allow 'o'
        urlsafe.set('o');
        // Allow space
        urlsafe.set(' ');
        // Allow 'w'
        urlsafe.set('w');
        // Allow 'r'
        urlsafe.set('r');
        // Allow 'd'
        urlsafe.set('d');
        // '!' should be encoded
        byte[] input = "hello world!".getBytes();
        // Act
        byte[] result = URLCodec.encodeUrl(urlsafe, input);
        // Assert
        // '!' should be encoded as %21
        byte[] expected = "hello+world%21".getBytes();
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEncodeUrl_WithSpecialCharacters_EncodesCorrectly() {
        // Arrange
        URLCodec urlCodec = new URLCodec();
        BitSet urlsafe = new BitSet();
        // Allow 'a'
        urlsafe.set('a');
        // Allow 'b'
        urlsafe.set('b');
        // Allow 'c'
        urlsafe.set('c');
        // '$', '&', '@', '!' should be encoded
        byte[] input = "abc$&@!".getBytes();
        // Act
        byte[] result = URLCodec.encodeUrl(urlsafe, input);
        // Assert
        // Expected encoded output
        byte[] expected = "abc%24%26%40%21".getBytes();
        assertArrayEquals(expected, result);
    }
}
