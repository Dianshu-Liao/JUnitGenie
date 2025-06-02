package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.BaseNCodec.Context;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_Base32_encode_byte_____int_int_Context_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testEncodeWithEofFalse() {
        Base32 base32 = new Base32();
        Context context = new Context();
        context.eof = false; // Set eof to false to enter the encoding logic

        byte[] input = new byte[] { 1, 2, 3, 4, 5 }; // Sample input
        int inPos = 0;
        int inAvail = input.length;

        try {
            base32.encode(input, inPos, inAvail, context);
            // Verify that the context.eof is still false after encoding
            assertFalse(context.eof);
        } catch (Exception e) {
            fail("Encoding should not throw an exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testEncodeWithEofTrue() {
        Base32 base32 = new Base32();
        Context context = new Context();
        context.eof = true; // Set eof to true to test early return

        byte[] input = new byte[] { 1, 2, 3, 4, 5 }; // Sample input
        int inPos = 0;
        int inAvail = input.length;

        try {
            base32.encode(input, inPos, inAvail, context);
            // Verify that the context.eof remains true after encoding
            assertTrue(context.eof);
        } catch (Exception e) {
            fail("Encoding should not throw an exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testEncodeWithNegativeInAvail() {
        Base32 base32 = new Base32();
        Context context = new Context();
        context.eof = false; // Set eof to false

        byte[] input = new byte[] { 1, 2, 3, 4, 5 }; // Sample input
        int inPos = 0;
        int inAvail = -1; // Simulate EOF condition

        try {
            base32.encode(input, inPos, inAvail, context);
            // Verify that the context.eof is set to true after encoding
            assertTrue(context.eof);
        } catch (Exception e) {
            fail("Encoding should not throw an exception: " + e.getMessage());
        }
    }

}