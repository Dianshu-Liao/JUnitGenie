package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base16;
import org.apache.commons.codec.binary.BaseNCodec.Context;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_Base16_decode_byte_____int_int_Context_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testDecodeValidInput() {
        Base16 base16 = new Base16();
        byte[] data = {(byte) 0x4d, (byte) 0x61}; // Equivalent to "Ma" in Base16
        Context context = new Context();
        int offset = 0;
        int length = data.length;

        try {
            base16.decode(data, offset, length, context);
            assertEquals(1, context.pos); // Ensure one byte has been processed
            assertEquals(0, context.ibitWorkArea); // Ensure ibitWorkArea is reset
        } catch (Exception e) {
            fail("An exception occurred during decoding: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testDecodeWithEof() {
        Base16 base16 = new Base16();
        byte[] data = {(byte) 0x4d}; // Incomplete byte input
        Context context = new Context();
        context.eof = true; // Set EOF to trigger EOF path
        int offset = 0;
        int length = data.length;

        try {
            base16.decode(data, offset, length, context);
            assertTrue(context.eof); // Ensure EOF is still set
        } catch (Exception e) {
            fail("An exception occurred during decoding: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testDecodeWithIncompleteData() {
        Base16 base16 = new Base16();
        byte[] data = {(byte) 0x4d}; // Incomplete byte input
        Context context = new Context();
        int offset = 0;
        int length = data.length;

        try {
            base16.decode(data, offset, length, context);
            assertEquals(1, context.ibitWorkArea); // Check that ibitWorkArea holds value
        } catch (Exception e) {
            fail("An exception occurred during decoding: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testDecodeNegativeLength() {
        Base16 base16 = new Base16();
        byte[] data = {(byte) 0x4d, (byte) 0x61}; // "Ma" in Base16
        Context context = new Context();
        int offset = 0;
        int length = -1; // Negative length

        try {
            base16.decode(data, offset, length, context);
            assertTrue(context.eof); // Ensure EOF is set as expected
        } catch (Exception e) {
            fail("An exception occurred during decoding: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testDecodeWithZeroLength() {
        Base16 base16 = new Base16();
        byte[] data = {}; // No data
        Context context = new Context();
        int offset = 0;
        int length = 0; // Zero length

        try {
            base16.decode(data, offset, length, context);
            assertTrue(context.eof); // Ensure EOF is set as expected
        } catch (Exception e) {
            fail("An exception occurred during decoding: " + e.getMessage());
        }
    }

}