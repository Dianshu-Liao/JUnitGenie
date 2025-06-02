package org.apache.commons.codec.net;
import org.apache.commons.codec.net.PercentCodec;
import org.apache.commons.codec.DecoderException;
import org.junit.Test;
import static org.junit.Assert.*;

public class net_PercentCodec_decode_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testDecodeWithNonByteArrayObject() {
        PercentCodec percentCodec = new PercentCodec();
        Object input = new Object(); // Non-byte array object

        try {
            percentCodec.decode(input);
            fail("Expected DecoderException to be thrown");
        } catch (DecoderException e) {
            assertEquals("Objects of type java.lang.Object cannot be Percent decoded", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testDecodeWithNull() {
        PercentCodec percentCodec = new PercentCodec();
        Object input = null;

        try {
            Object result = percentCodec.decode(input);
            assertNull(result);
        } catch (DecoderException e) {
            fail("DecoderException should not be thrown for null input");
        }
    }

}