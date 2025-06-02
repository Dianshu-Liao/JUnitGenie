package org.apache.commons.codec.net;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.PercentCodec;
import org.junit.Test;
import static org.junit.Assert.*;

public class net_PercentCodec_encode_Object_cfg_path_1_Test {

    private final PercentCodec percentCodec = new PercentCodec();

    @Test(timeout = 4000)
    public void testEncodeWithInvalidObject() {
        Object invalidObject = new Object(); // An object that is not a byte array
        try {
            percentCodec.encode(invalidObject);
            fail("Expected EncoderException to be thrown");
        } catch (EncoderException e) {
            assertEquals("Objects of type java.lang.Object cannot be Percent encoded", e.getMessage());
        }
    }

}