package org.apache.commons.codec.net;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import java.util.BitSet;

public class net_URLCodec_encodeUrl_BitSet_byte_____cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testEncodeUrlWithNullBytes() {
        BitSet urlsafe = new BitSet();
        byte[] bytes = null;

        try {
            byte[] result = URLCodec.encodeUrl(urlsafe, bytes);
            assertArrayEquals(null, result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }


}