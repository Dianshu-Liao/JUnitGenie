package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.BaseNCodec.Context;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_Base32_encode_byte_____int_int_Context_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEncode() {
        Base32 base32 = new Base32();
        Context context = new Context();
        byte[] input = { (byte) 0xFF, (byte) 0x00, (byte) 0x01 }; // Sample input
        int inPos = 0;
        int inAvail = input.length;

        // Set up context
        context.eof = false;
        context.modulus = 0;
        context.pos = 0;
        context.lbitWorkArea = 0;
        context.currentLinePos = 0;

        try {
            base32.encode(input, inPos, inAvail, context);
        } catch (IllegalStateException e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Validate the context state after encoding
        assertFalse("EOF should not be set", context.eof);
        assertTrue("Position should be updated", context.pos > 0);
        assertTrue("Current line position should be updated", context.currentLinePos > 0);
    }

    @Test(timeout = 4000)
    public void testEncodeWithEOF() {
        Base32 base32 = new Base32();
        Context context = new Context();
        byte[] input = {}; // Empty input to simulate EOF
        int inPos = 0;
        int inAvail = input.length;

        // Set up context
        context.eof = true; // Simulate EOF
        context.modulus = 0;
        context.pos = 0;
        context.lbitWorkArea = 0;
        context.currentLinePos = 0;

        try {
            base32.encode(input, inPos, inAvail, context);
        } catch (IllegalStateException e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Validate that EOF is still set
        assertTrue("EOF should be set", context.eof);
        assertEquals("Position should remain unchanged", 0, context.pos);
    }

}