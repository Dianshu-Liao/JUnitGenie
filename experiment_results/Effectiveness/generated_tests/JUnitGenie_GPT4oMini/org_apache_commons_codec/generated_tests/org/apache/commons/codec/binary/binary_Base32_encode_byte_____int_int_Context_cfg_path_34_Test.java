package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.BaseNCodec.Context;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_Base32_encode_byte_____int_int_Context_cfg_path_34_Test {

    @Test(timeout = 4000)
    public void testEncodeWithValidInput() {
        Base32 base32 = new Base32();
        byte[] input = { (byte) 0xFF, (byte) 0x00, (byte) 0x01 };
        Context context = new Context();
        context.eof = false;
        context.modulus = 0;
        context.pos = 0;
        context.lbitWorkArea = 0;
        context.currentLinePos = 0;

        try {
            base32.encode(input, 0, input.length, context);
            // Validate the context state after encoding
            assertFalse(context.eof);
            assertTrue(context.pos > 0); // Ensure some data was written
        } catch (Exception e) {
            fail("Encoding failed with exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testEncodeWithEOF() {
        Base32 base32 = new Base32();
        byte[] input = {};
        Context context = new Context();
        context.eof = true; // Simulate EOF
        context.modulus = 0;
        context.pos = 0;
        context.lbitWorkArea = 0;
        context.currentLinePos = 0;

        try {
            base32.encode(input, 0, 0, context);
            // Validate that EOF is handled correctly
            assertTrue(context.eof);
            assertEquals(0, context.pos); // No data should be written
        } catch (Exception e) {
            fail("Encoding failed with exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testEncodeWithNegativeInAvail() {
        Base32 base32 = new Base32();
        byte[] input = { (byte) 0xFF, (byte) 0x00, (byte) 0x01 };
        Context context = new Context();
        context.eof = false;
        context.modulus = 0;
        context.pos = 0;
        context.lbitWorkArea = 0;
        context.currentLinePos = 0;

        try {
            base32.encode(input, 0, -1, context);
            // Validate that EOF is set
            assertTrue(context.eof);
            assertEquals(0, context.pos); // No data should be written
        } catch (Exception e) {
            fail("Encoding failed with exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testEncodeWithInvalidModulus() {
        Base32 base32 = new Base32();
        byte[] input = { (byte) 0xFF, (byte) 0x00, (byte) 0x01 };
        Context context = new Context();
        context.eof = false;
        context.modulus = 5; // Invalid modulus
        context.pos = 0;
        context.lbitWorkArea = 0;
        context.currentLinePos = 0;

        try {
            base32.encode(input, 0, input.length, context);
            fail("Expected IllegalStateException for invalid modulus");
        } catch (IllegalStateException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Encoding failed with unexpected exception: " + e.getMessage());
        }
    }

}