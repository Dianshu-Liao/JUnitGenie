package org.apache.commons.codec.net;
import org.apache.commons.codec.net.PercentCodec;
import org.apache.commons.codec.EncoderException;
import org.junit.Test;
import static org.junit.Assert.*;

public class net_PercentCodec_encode_Object_cfg_path_2_Test {

    private final PercentCodec percentCodec = new PercentCodec();

    @Test(timeout = 4000)
    public void testEncode_NullInput() {
        try {
            Object result = percentCodec.encode(null);
            assertNull(result);
        } catch (EncoderException e) {
            fail("EncoderException should not be thrown for null input");
        }
    }

    @Test(timeout = 4000)
    public void testEncode_NonByteArrayInput() {
        try {
            Object result = percentCodec.encode("testString");
            fail("EncoderException should be thrown for non-byte array input");
        } catch (EncoderException e) {
            assertEquals("Objects of type java.lang.String cannot be Percent encoded", e.getMessage());
        }
    }

}