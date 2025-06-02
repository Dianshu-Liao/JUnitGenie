package org.apache.commons.codec.net;
import org.apache.commons.codec.net.BCodec;
import org.apache.commons.codec.EncoderException;
import org.junit.Test;
import static org.junit.Assert.*;

public class net_BCodec_encode_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEncodeWithNonStringObject() {
        BCodec codec = new BCodec();
        Object nonStringObject = new Object(); // Create a non-string object

        try {
            codec.encode(nonStringObject);
            fail("Expected EncoderException to be thrown");
        } catch (EncoderException e) {
            assertEquals("Objects of type java.lang.Object cannot be encoded using BCodec", e.getMessage());
        }
    }

}