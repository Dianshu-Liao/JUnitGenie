package org.apache.commons.codec.net;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.codec.EncoderException;
import org.junit.Test;
import static org.junit.Assert.*;

public class net_URLCodec_encode_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEncodeWithUnsupportedType() {
        URLCodec urlCodec = new URLCodec();
        Object unsupportedObject = new Object(); // An instance of a class that cannot be URL encoded

        try {
            urlCodec.encode(unsupportedObject);
            fail("Expected EncoderException to be thrown");
        } catch (EncoderException e) {
            assertEquals("Objects of type java.lang.Object cannot be URL encoded", e.getMessage());
        }
    }

}