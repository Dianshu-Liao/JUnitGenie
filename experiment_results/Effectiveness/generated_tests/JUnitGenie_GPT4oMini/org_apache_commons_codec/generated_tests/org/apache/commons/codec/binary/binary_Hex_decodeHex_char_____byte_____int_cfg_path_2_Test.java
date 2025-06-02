package org.apache.commons.codec.binary;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_Hex_decodeHex_char_____byte_____int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testDecodeHex_OutputArrayTooSmall() {
        char[] data = {'1', '2', '3', '4'};
        byte[] out = new byte[2]; // Output array is too small
        int outOffset = 0;

        try {
            Hex.decodeHex(data, out, outOffset);
            fail("Expected DecoderException was not thrown.");
        } catch (DecoderException e) {
            assertEquals("Output array is not large enough to accommodate decoded data.", e.getMessage());
        }
    }

}