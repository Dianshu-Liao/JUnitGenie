package org.apache.commons.codec.net;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.codec.EncoderException;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class net_URLCodec_encode_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEncode_NullInput() throws Exception {
        URLCodec codec = new URLCodec();
        // Explicitly cast null to String to resolve ambiguity
        String result = codec.encode((String) null);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testEncode_ThrowsEncoderException() {
        URLCodec codec = new URLCodec("invalid-charset");
        try {
            codec.encode("test");
        } catch (EncoderException e) {
            // Expected exception
            return;
        }
        // If we reach here, the exception was not thrown
        throw new AssertionError("Expected EncoderException was not thrown");
    }


}