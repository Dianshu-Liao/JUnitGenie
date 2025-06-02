package org.apache.commons.codec.binary;

import java.io.UnsupportedEncodingException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.CharEncoding;

public class StringUtils_getBytesUnchecked_5_0_Test {

    @Test
    public void testGetBytesUnchecked_NullString() {
        byte[] result = StringUtils.getBytesUnchecked(null, "UTF-8");
        assertNull(result, "Expected null for null input string");
    }

    @Test
    public void testGetBytesUnchecked_ValidStringAndCharset() {
        String input = "Hello";
        String charset = "UTF-8";
        byte[] result = StringUtils.getBytesUnchecked(input, charset);
        try {
            assertArrayEquals("Hello".getBytes(charset), result, "The byte arrays should match for valid input");
        } catch (UnsupportedEncodingException e) {
            fail("Unexpected UnsupportedEncodingException: " + e.getMessage());
        }
    }

    @Test
    public void testGetBytesUnchecked_UnsupportedEncoding() {
        String input = "Hello";
        String charset = "unsupported-charset";
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            StringUtils.getBytesUnchecked(input, charset);
        });
        String expectedMessage = "Unsupported encoding: " + charset;
        assertTrue(exception.getMessage().contains(expectedMessage), "Expected IllegalStateException for unsupported charset");
    }
}
