package org.apache.commons.codec.net;
import org.apache.commons.codec.net.PercentCodec;
import org.apache.commons.codec.DecoderException;
import org.junit.Test;
import static org.junit.Assert.*;

public class net_PercentCodec_decode_Object_cfg_path_1_Test {

    private final PercentCodec percentCodec = new PercentCodec();

    @Test(timeout = 4000)
    public void testDecodeWithInvalidObjectType() {
        Object invalidObject = new Object(); // An object that is not a byte array
        try {
            percentCodec.decode(invalidObject);
            fail("Expected DecoderException to be thrown");
        } catch (DecoderException e) {
            assertEquals("Objects of type java.lang.Object cannot be Percent decoded", e.getMessage());
        }
    }

}