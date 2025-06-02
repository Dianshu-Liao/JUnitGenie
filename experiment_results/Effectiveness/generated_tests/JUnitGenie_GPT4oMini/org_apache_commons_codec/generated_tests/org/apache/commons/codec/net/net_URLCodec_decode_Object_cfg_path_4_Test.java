package org.apache.commons.codec.net;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class net_URLCodec_decode_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testDecode_nullObject() {
        URLCodec codec = new URLCodec();
        try {
            // Explicitly casting null to String to resolve ambiguity
            String result = codec.decode((String) null);
            assertNull("Expected null when decoding a null object", result);
        } catch (DecoderException e) {
            // This block should not be reached
            e.printStackTrace();
        }
    }


}