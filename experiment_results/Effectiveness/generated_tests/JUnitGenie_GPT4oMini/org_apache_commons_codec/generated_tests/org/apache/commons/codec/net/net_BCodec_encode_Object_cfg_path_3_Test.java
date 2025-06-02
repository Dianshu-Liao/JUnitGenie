package org.apache.commons.codec.net;
import org.apache.commons.codec.net.BCodec;
import org.apache.commons.codec.EncoderException;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class net_BCodec_encode_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEncode_NullValue() {
        BCodec codec = new BCodec();
        try {
            Object result = codec.encode(null);
            assertNull(result);
        } catch (EncoderException e) {
            // Handle exception if occurs
        }
    }

}