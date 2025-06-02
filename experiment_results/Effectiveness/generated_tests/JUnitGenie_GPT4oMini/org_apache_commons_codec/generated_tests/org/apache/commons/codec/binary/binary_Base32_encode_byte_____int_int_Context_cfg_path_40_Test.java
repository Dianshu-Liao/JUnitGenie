package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.BaseNCodec.Context;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_Base32_encode_byte_____int_int_Context_cfg_path_40_Test {

    @Test(timeout = 4000)
    public void testEncodeWithEof() {
        Base32 base32 = new Base32();
        Context context = new Context();
        context.eof = false; // Set EOF to false initially
        byte[] input = new byte[] { 0, 1, 2, 3, 4, 5 };
        int inPos = 0;
        int inAvail = -1; // Simulate EOF

        try {
            base32.encode(input, inPos, inAvail, context);
            assertTrue(context.eof); // Check if EOF is set to true
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testEncodeWithValidInput() {
        Base32 base32 = new Base32();
        Context context = new Context();
        context.eof = false; // Set EOF to false
        byte[] input = new byte[] { 0, 1, 2, 3, 4, 5 };
        int inPos = 0;
        int inAvail = input.length; // Valid input length

        try {
            base32.encode(input, inPos, inAvail, context);
            // Validate the context's pos and currentLinePos after encoding
            assertTrue(context.pos > 0);
            assertTrue(context.currentLinePos >= 0);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testEncodeWithModulus() {
        Base32 base32 = new Base32();
        Context context = new Context();
        context.eof = false; // Set EOF to false
        context.modulus = 1; // Set modulus to 1
        byte[] input = new byte[] { 0, 1, 2, 3, 4, 5 };
        int inPos = 0;
        int inAvail = input.length; // Valid input length

        try {
            base32.encode(input, inPos, inAvail, context);
            // Validate the context's pos and currentLinePos after encoding
            assertTrue(context.pos > 0);
            assertTrue(context.currentLinePos >= 0);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

}