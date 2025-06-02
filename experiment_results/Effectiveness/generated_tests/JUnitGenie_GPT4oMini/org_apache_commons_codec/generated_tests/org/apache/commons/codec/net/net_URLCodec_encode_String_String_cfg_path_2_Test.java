package org.apache.commons.codec.net;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import java.io.UnsupportedEncodingException;

public class net_URLCodec_encode_String_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEncodeWithNullString() {
        URLCodec urlCodec = new URLCodec();
        try {
            String result = urlCodec.encode(null, "UTF-8");
            assertNull(result);
        } catch (UnsupportedEncodingException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }


}