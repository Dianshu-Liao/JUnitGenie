package org.apache.commons.codec.net;
import org.apache.commons.codec.net.BCodec;
import org.apache.commons.codec.EncoderException;
import org.junit.Test;
import static org.junit.Assert.*;

public class net_BCodec_encode_String_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEncode_throwsEncoderException_forUnsupportedCharset() {
        BCodec codec = new BCodec();
        String strSource = "test";
        String sourceCharset = "unsupported-charset"; // This should trigger the UnsupportedCharsetException

        try {
            codec.encode(strSource, sourceCharset);
            fail("Expected EncoderException to be thrown");
        } catch (EncoderException e) {
            assertNotNull(e.getMessage());
        }
    }

}