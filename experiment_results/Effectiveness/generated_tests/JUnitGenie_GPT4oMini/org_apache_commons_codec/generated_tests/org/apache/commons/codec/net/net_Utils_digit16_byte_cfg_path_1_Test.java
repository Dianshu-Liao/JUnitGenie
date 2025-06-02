package org.apache.commons.codec.net;
import org.apache.commons.codec.net.Utils;
import org.apache.commons.codec.DecoderException;
import org.junit.Test;
import static org.junit.Assert.*;

public class net_Utils_digit16_byte_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testDigit16ThrowsDecoderException() {
        byte invalidByte = (byte) 255; // This byte value will not correspond to a valid digit in radix 16
        try {
            Utils.digit16(invalidByte);
            fail("Expected DecoderException to be thrown");
        } catch (DecoderException e) {
            assertEquals("Invalid URL encoding: not a valid digit (radix 16): " + invalidByte, e.getMessage());
        }
    }

}