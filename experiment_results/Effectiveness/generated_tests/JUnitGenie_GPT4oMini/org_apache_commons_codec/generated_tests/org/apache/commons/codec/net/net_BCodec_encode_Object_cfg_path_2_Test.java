package org.apache.commons.codec.net;
import org.apache.commons.codec.net.BCodec;
import org.apache.commons.codec.EncoderException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class net_BCodec_encode_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEncodeWithValidString() {
        BCodec bCodec = new BCodec();
        String input = "testString";
        try {
            Object result = bCodec.encode(input);
            // Assuming the encode method returns the same string for this example
            assertEquals(input, result);
        } catch (EncoderException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEncodeWithNull() {
        BCodec bCodec = new BCodec();
        try {
            Object result = bCodec.encode(null);
            assertEquals(null, result);
        } catch (EncoderException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEncodeWithInvalidType() {
        BCodec bCodec = new BCodec();
        Object input = new Object(); // Invalid type
        try {
            bCodec.encode(input);
        } catch (EncoderException e) {
            // Expected exception
            assertEquals("Objects of type java.lang.Object cannot be encoded using BCodec", e.getMessage());
        }
    }

}