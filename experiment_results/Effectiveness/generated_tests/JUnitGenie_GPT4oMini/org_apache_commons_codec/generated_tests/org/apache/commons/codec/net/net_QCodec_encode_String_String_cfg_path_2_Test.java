package org.apache.commons.codec.net;
import org.apache.commons.codec.net.QCodec;
import org.apache.commons.codec.EncoderException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class net_QCodec_encode_String_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEncode() {
        QCodec codec = new QCodec();
        String sourceStr = "Hello World";
        String sourceCharset = "UTF-8";
        
        try {
            String result = codec.encode(sourceStr, sourceCharset);
            // Assuming encodeText returns the same string for this example
            assertEquals("Hello World", result);
        } catch (EncoderException e) {
            // Handle the EncoderException if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEncodeWithUnsupportedCharset() {
        QCodec codec = new QCodec();
        String sourceStr = "Hello World";
        String sourceCharset = "UnsupportedCharset"; // This should trigger the exception
        
        try {
            codec.encode(sourceStr, sourceCharset);
        } catch (EncoderException e) {
            // Expected exception, can assert the message if needed
            assertEquals("UnsupportedCharset", e.getCause().getMessage());
        }
    }

}