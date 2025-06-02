package org.apache.commons.codec.net;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.codec.EncoderException;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class net_URLCodec_encode_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testEncode_NullInput() {
        URLCodec urlCodec = new URLCodec();
        try {
            // Explicitly call the encode method for String by casting null to String
            String result = urlCodec.encode((String) null);
            assertNull(result);
        } catch (EncoderException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }


}