package org.apache.commons.codec.net;
import org.apache.commons.codec.net.PercentCodec;
import org.apache.commons.codec.EncoderException;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class net_PercentCodec_encode_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEncode_NullObject() {
        PercentCodec percentCodec = new PercentCodec();
        try {
            Object result = percentCodec.encode(null);
            assertNull(result);
        } catch (EncoderException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}