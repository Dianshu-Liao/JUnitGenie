package org.apache.commons.codec.net;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.io.UnsupportedEncodingException;

public class net_URLCodec_encode_String_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEncodeWithValidInput() {
        URLCodec codec = new URLCodec();
        String input = "Hello World";
        String charset = "UTF-8";
        try {
            String result = codec.encode(input, charset);
            // Expected result after encoding
            String expected = "Hello%20World"; // Adjust based on actual expected output
            assertEquals(expected, result);
        } catch (UnsupportedEncodingException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEncodeWithNullInput() {
        URLCodec codec = new URLCodec();
        String input = null;
        String charset = "UTF-8";
        try {
            String result = codec.encode(input, charset);
            assertNull(result);
        } catch (UnsupportedEncodingException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEncodeWithEmptyString() {
        URLCodec codec = new URLCodec();
        String input = "";
        String charset = "UTF-8";
        try {
            String result = codec.encode(input, charset);
            // Expected result after encoding
            String expected = ""; // Adjust based on actual expected output
            assertEquals(expected, result);
        } catch (UnsupportedEncodingException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEncodeWithUnsupportedCharset() {
        URLCodec codec = new URLCodec();
        String input = "Hello World";
        String charset = "INVALID_CHARSET";
        try {
            codec.encode(input, charset);
        } catch (UnsupportedEncodingException e) {
            // Expected exception for unsupported charset
            // You can assert the exception message if needed
        }
    }

}