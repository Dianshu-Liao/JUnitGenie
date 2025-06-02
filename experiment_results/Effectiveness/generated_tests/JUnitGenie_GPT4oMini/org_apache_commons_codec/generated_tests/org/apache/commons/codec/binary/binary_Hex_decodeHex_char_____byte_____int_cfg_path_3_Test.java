package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.DecoderException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class binary_Hex_decodeHex_char_____byte_____int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testDecodeHex() {
        char[] data = new char[] {'1', 'a', '2', 'b'};
        byte[] out = new byte[2];
        int outOffset = 0;

        try {
            int result = Hex.decodeHex(data, out, outOffset);
            assertEquals(2, result);
            assertEquals((byte) 0x1A, out[0]);
            assertEquals((byte) 0x2B, out[1]);
        } catch (DecoderException e) {
            // Handle the exception if needed
        }
    }

    @Test(expected = DecoderException.class)
    public void testDecodeHexOddLength() throws DecoderException {
        char[] data = new char[] {'1', 'a', '2'};
        byte[] out = new byte[2];
        int outOffset = 0;

        Hex.decodeHex(data, out, outOffset);
    }

    @Test(expected = DecoderException.class)
    public void testDecodeHexInsufficientOutputArray() throws DecoderException {
        char[] data = new char[] {'1', 'a', '2', 'b'};
        byte[] out = new byte[1]; // Not enough space
        int outOffset = 0;

        Hex.decodeHex(data, out, outOffset);
    }

}