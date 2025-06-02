package org.apache.commons.codec.net;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.QCodec;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class net_QCodec_encode_String_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEncodeThrowsEncoderException() {
        QCodec codec = new QCodec();
        String sourceStr = "Hello, World!";
        String sourceCharset = "UnsupportedCharset"; // Assuming this is an unsupported charset.

        try {
            codec.encode(sourceStr, sourceCharset);
            // If no exception is thrown, fail the test
            assertEquals("Expected EncoderException but none was thrown.", true, false);
        } catch (EncoderException e) {
            // Here we can verify the message if needed
            assertEquals("UnsupportedCharset", e.getCause().getMessage());
        }
    }

}