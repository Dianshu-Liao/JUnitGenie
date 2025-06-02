package org.apache.commons.codec.net;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.codec.DecoderException;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class net_URLCodec_decode_String_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testDecodeWithNullString() {
        URLCodec urlCodec = new URLCodec();
        try {
            String result = urlCodec.decode(null, "UTF-8");
            assertNull(result);
        } catch (DecoderException | UnsupportedEncodingException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}