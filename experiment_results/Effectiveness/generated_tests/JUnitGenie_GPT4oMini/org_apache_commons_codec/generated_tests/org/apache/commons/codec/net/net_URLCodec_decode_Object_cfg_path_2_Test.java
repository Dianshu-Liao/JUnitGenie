package org.apache.commons.codec.net;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;
import static org.junit.Assert.*;

public class net_URLCodec_decode_Object_cfg_path_2_Test {

    private final URLCodec urlCodec = new URLCodec();

    @Test(timeout = 4000)
    public void testDecodeWithInvalidObjectType() {
        Object invalidObject = new Object(); // An object that is neither byte[] nor String
        try {
            urlCodec.decode(invalidObject);
            fail("Expected DecoderException to be thrown");
        } catch (DecoderException e) {
            assertEquals("Objects of type java.lang.Object cannot be URL decoded", e.getMessage());
        }
    }

}