package org.apache.commons.codec.net;
import org.apache.commons.codec.net.PercentCodec;
import org.apache.commons.codec.DecoderException;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class net_PercentCodec_decode_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testDecode_NullInput() {
        PercentCodec codec = new PercentCodec();
        try {
            Object result = codec.decode(null);
            assertNull(result);
        } catch (DecoderException e) {
            // This block should not be reached as we expect null to be returned
            e.printStackTrace();
        }
    }

}