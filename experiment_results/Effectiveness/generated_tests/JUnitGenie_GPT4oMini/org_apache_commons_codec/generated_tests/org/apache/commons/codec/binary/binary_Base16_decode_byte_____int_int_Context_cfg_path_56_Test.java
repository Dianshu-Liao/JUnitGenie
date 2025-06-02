package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base16;
import org.apache.commons.codec.binary.BaseNCodec.Context;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_Base16_decode_byte_____int_int_Context_cfg_path_56_Test {

    @Test(timeout = 4000)
    public void testDecode() {
        Base16 base16 = new Base16();
        Context context = new Context();
        context.eof = false;
        context.ibitWorkArea = 0;
        context.pos = 0;

        byte[] data = new byte[] { 0x0A, 0x0B }; // Valid Base16 input
        int offset = 0;
        int length = data.length;

        try {
            base16.decode(data, offset, length, context);
            // Validate the context's pos and ibitWorkArea after decoding
            assertEquals(1, context.pos);
            assertEquals(0, context.ibitWorkArea);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testDecodeWithEof() {
        Base16 base16 = new Base16();
        Context context = new Context();
        context.eof = true; // Set EOF to true
        context.ibitWorkArea = 0;
        context.pos = 0;

        byte[] data = new byte[] { 0x0A, 0x0B }; // Valid Base16 input
        int offset = 0;
        int length = data.length;

        try {
            base16.decode(data, offset, length, context);
            // Validate that pos remains unchanged
            assertEquals(0, context.pos);
            assertEquals(0, context.ibitWorkArea);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testDecodeWithNegativeLength() {
        Base16 base16 = new Base16();
        Context context = new Context();
        context.eof = false;
        context.ibitWorkArea = 0;
        context.pos = 0;

        byte[] data = new byte[] { 0x0A, 0x0B }; // Valid Base16 input
        int offset = 0;
        int length = -1; // Invalid length

        try {
            base16.decode(data, offset, length, context);
            // Validate that pos remains unchanged
            assertEquals(0, context.pos);
            assertEquals(0, context.ibitWorkArea);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testDecodeWithHalfByte() {
        Base16 base16 = new Base16();
        Context context = new Context();
        context.eof = false;
        context.ibitWorkArea = 1; // Simulate having a half byte
        context.pos = 0;

        byte[] data = new byte[] { 0x0A }; // Valid Base16 input
        int offset = 0;
        int length = data.length;

        try {
            base16.decode(data, offset, length, context);
            // Validate the context's pos and ibitWorkArea after decoding
            assertEquals(1, context.pos);
            assertEquals(0, context.ibitWorkArea);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

}