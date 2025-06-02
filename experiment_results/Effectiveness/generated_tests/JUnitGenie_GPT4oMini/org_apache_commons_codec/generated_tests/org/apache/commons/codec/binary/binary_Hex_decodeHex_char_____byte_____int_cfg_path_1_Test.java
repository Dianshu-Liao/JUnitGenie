package org.apache.commons.codec.binary;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_Hex_decodeHex_char_____byte_____int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testDecodeHex_OddNumberOfCharacters() {
        char[] data = {'1', '2', '3'}; // Odd number of characters
        byte[] out = new byte[2];
        int outOffset = 0;

        try {
            Hex.decodeHex(data, out, outOffset);
            fail("Expected DecoderException not thrown");
        } catch (DecoderException e) {
            assertEquals("Odd number of characters.", e.getMessage());
        }
    }

}