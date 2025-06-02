package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.BaseNCodec.Context;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_Base32_encode_byte_____int_int_Context_cfg_path_43_Test {

    @Test(timeout = 4000)
    public void testEncodeWithEofFalse() {
        Base32 base32 = new Base32();
        Context context = new Context();
        context.eof = false; // Set eof to false to cover the path

        byte[] input = new byte[]{1, 2, 3, 4, 5}; // Sample input
        int inPos = 0;
        int inAvail = input.length;

        try {
            base32.encode(input, inPos, inAvail, context);
            // Verify that the method completes without throwing an exception
            assertFalse(context.eof); // Ensure eof is still false
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

}