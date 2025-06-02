package org.apache.commons.codec.net;
import org.apache.commons.codec.net.Utils;
import org.apache.commons.codec.DecoderException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class net_Utils_digit16_byte_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testDigit16_ValidInput() {
        byte input = 'A'; // Valid hexadecimal digit
        try {
            int result = Utils.digit16(input);
            assertEquals(10, result); // 'A' corresponds to 10 in decimal
        } catch (DecoderException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDigit16_InvalidInput() {
        byte input = 'G'; // Invalid hexadecimal digit
        try {
            Utils.digit16(input);
        } catch (DecoderException e) {
            // Expected exception for invalid input
            assertEquals("Invalid URL encoding: not a valid digit (radix 16): 71", e.getMessage());
        }
    }

}