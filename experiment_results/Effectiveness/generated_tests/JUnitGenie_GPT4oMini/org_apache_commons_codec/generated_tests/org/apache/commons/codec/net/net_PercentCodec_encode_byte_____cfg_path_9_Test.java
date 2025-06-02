package org.apache.commons.codec.net;
import org.apache.commons.codec.net.PercentCodec;
import org.apache.commons.codec.EncoderException;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class net_PercentCodec_encode_byte_____cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testEncode_NullInput() {
        PercentCodec percentCodec = new PercentCodec();
        byte[] result = null;
        try {
            result = percentCodec.encode(null);
        } catch (EncoderException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
        assertNull(result);
    }

}