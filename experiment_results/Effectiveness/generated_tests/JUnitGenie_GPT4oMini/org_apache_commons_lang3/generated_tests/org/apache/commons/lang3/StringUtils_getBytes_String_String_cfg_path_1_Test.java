package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.io.UnsupportedEncodingException;

public class StringUtils_getBytes_String_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetBytes_ValidInput() {
        String input = "Hello, World!";
        String charset = "UTF-8";
        byte[] expected = new byte[0];
        try {
            expected = input.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            // This should not happen with a valid charset
            assertEquals("UTF-8", e.getMessage());
        }

        byte[] result = new byte[0];
        try {
            result = StringUtils.getBytes(input, charset);
        } catch (UnsupportedEncodingException e) {
            // This should not happen with a valid charset
            assertEquals("UTF-8", e.getMessage());
        }
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testGetBytes_NullString() {
        String input = null;
        String charset = "UTF-8";
        byte[] expected = new byte[0]; // ArrayUtils.EMPTY_BYTE_ARRAY

        byte[] result = new byte[0];
        try {
            result = StringUtils.getBytes(input, charset);
        } catch (UnsupportedEncodingException e) {
            // This should not happen with a null input
            assertEquals("UTF-8", e.getMessage());
        }
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testGetBytes_InvalidCharset() {
        String input = "Invalid Charset Example";
        String charset = "invalid-charset"; // A non-standard charset
        
        try {
            StringUtils.getBytes(input, charset);
        } catch (UnsupportedEncodingException e) {
            // Expected exception for invalid charset
            assertEquals("Unknown charset: invalid-charset", e.getMessage());
        }
    }

}