package org.apache.commons.codec.binary;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class binary_Hex_decodeHex_char_____byte_____int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testDecodeHex() {
        try {
            char[] data = {'1', 'A', '2', 'B', '3', 'C', '4', 'D'};
            byte[] out = new byte[4];
            int outOffset = 0;

            int result = Hex.decodeHex(data, out, outOffset);
            assertEquals(4, result);
            // Check if the output array has correct byte values
            assertEquals(26, out[0]);
            assertEquals(43, out[1]);
            assertEquals(60, out[2]);
            assertEquals(77, out[3]);
        } catch (DecoderException e) {
            e.printStackTrace();
        }
    }

}