package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.BaseNCodec.Context;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_Base32_encode_byte_____int_int_Context_cfg_path_26_Test {

    @Test(timeout = 4000)
    public void testEncodeWithEofFalse() {
        Base32 base32 = new Base32();
        Context context = new Context();
        context.eof = false; // Set eof to false to enter the encoding logic
        context.modulus = 0; // Initial modulus value
        byte[] input = { (byte) 0xFF, (byte) 0x00, (byte) 0x01 }; // Sample input
        int inPos = 0;
        int inAvail = input.length;

        try {
            base32.encode(input, inPos, inAvail, context);
            // Add assertions to verify the expected behavior after encoding
            assertFalse(context.eof); // Ensure eof is still false
            assertEquals(3, context.modulus); // Check modulus value after processing
        } catch (Exception e) {
            fail("Encoding threw an exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testEncodeWithEofTrue() {
        Base32 base32 = new Base32();
        Context context = new Context();
        context.eof = true; // Set eof to true to test early return
        context.modulus = 0; // Initial modulus value
        byte[] input = { (byte) 0xFF, (byte) 0x00, (byte) 0x01 }; // Sample input
        int inPos = 0;
        int inAvail = input.length;

        try {
            base32.encode(input, inPos, inAvail, context);
            // Add assertions to verify the expected behavior after encoding
            assertTrue(context.eof); // Ensure eof is true
            assertEquals(0, context.modulus); // Check modulus value remains unchanged
        } catch (Exception e) {
            fail("Encoding threw an exception: " + e.getMessage());
        }
    }

}