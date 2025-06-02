package org.apache.commons.codec.net;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.codec.DecoderException;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class net_URLCodec_decode_String_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testDecode_ValidInput() {
        URLCodec codec = new URLCodec();
        String input = "Hello%20World"; // URL encoded string
        String charset = "UTF-8"; // Valid charset

        try {
            String result = codec.decode(input, charset);
            assertEquals("Hello World", result); // Expected decoded output
        } catch (DecoderException | UnsupportedEncodingException e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDecode_NullInput() {
        URLCodec codec = new URLCodec();
        String input = null; // Null input
        String charset = "UTF-8"; // Valid charset

        try {
            String result = codec.decode(input, charset);
            assertEquals(null, result); // Expected output is null
        } catch (DecoderException | UnsupportedEncodingException e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDecode_EmptyString() {
        URLCodec codec = new URLCodec();
        String input = ""; // Empty string
        String charset = "UTF-8"; // Valid charset

        try {
            String result = codec.decode(input, charset);
            assertEquals("", result); // Expected output is empty string
        } catch (DecoderException | UnsupportedEncodingException e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDecode_InvalidCharset() {
        URLCodec codec = new URLCodec();
        String input = "Hello%20World"; // URL encoded string
        String charset = "InvalidCharset"; // Invalid charset

        try {
            codec.decode(input, charset);
        } catch (DecoderException e) {
            // Expected exception for invalid charset
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // Expected exception for unsupported encoding
            e.printStackTrace();
        }
    }

}