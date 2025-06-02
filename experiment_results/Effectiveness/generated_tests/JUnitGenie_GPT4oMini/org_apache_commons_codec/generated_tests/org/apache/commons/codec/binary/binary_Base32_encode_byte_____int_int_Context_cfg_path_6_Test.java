package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.BaseNCodec.Context;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_Base32_encode_byte_____int_int_Context_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testEncode() {
        Base32 base32 = new Base32();
        Context context = new Context();
        byte[] input = { (byte) 0xFF, (byte) 0x00, (byte) 0x01 }; // Sample input
        int inPos = 0;
        int inAvail = input.length;

        // Set up context
        context.eof = false; // Ensure EOF is false to enter the main encoding logic
        context.modulus = 0; // Initial modulus
        context.pos = 0; // Initial position
        context.lbitWorkArea = 0; // Initial work area
        context.currentLinePos = 0; // Initial line position

        try {
            base32.encode(input, inPos, inAvail, context);
        } catch (IllegalStateException e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Validate the context state after encoding
        assertTrue("Expected modulus to be updated", context.modulus > 0);
        assertTrue("Expected position to be updated", context.pos > 0);
        assertFalse("Expected EOF to remain false", context.eof);
    }

    @Test(timeout = 4000)
    public void testEncodeEOF() {
        Base32 base32 = new Base32();
        Context context = new Context();
        byte[] input = {}; // Empty input to simulate EOF
        int inPos = 0;
        int inAvail = -1; // Indicate EOF

        // Set up context
        context.eof = false; // Ensure EOF is false to enter the main encoding logic
        context.modulus = 0; // Initial modulus
        context.pos = 0; // Initial position
        context.lbitWorkArea = 0; // Initial work area
        context.currentLinePos = 0; // Initial line position

        try {
            base32.encode(input, inPos, inAvail, context);
        } catch (IllegalStateException e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Validate the context state after encoding
        assertTrue("Expected EOF to be true", context.eof);
    }

}