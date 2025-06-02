package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.BaseNCodec.Context;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_Base32_encode_byte_____int_int_Context_cfg_path_29_Test {

    @Test(timeout = 4000)
    public void testEncodeWithValidInput() {
        Base32 base32 = new Base32();
        byte[] input = { (byte) 0xFF, (byte) 0x00, (byte) 0x01 };
        int inPos = 0;
        int inAvail = input.length;
        Context context = new Context();
        context.eof = false; // Ensure EOF is false to enter the encoding logic

        try {
            base32.encode(input, inPos, inAvail, context);
            // Validate the context state after encoding
            assertFalse(context.eof);
            assertTrue(context.pos > 0); // Ensure some data was written
        } catch (Exception e) {
            fail("Encoding should not throw an exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testEncodeWithEOF() {
        Base32 base32 = new Base32();
        byte[] input = {};
        int inPos = 0;
        int inAvail = -1; // Indicate EOF
        Context context = new Context();
        context.eof = false; // Ensure EOF is false to enter the encoding logic

        try {
            base32.encode(input, inPos, inAvail, context);
            // Validate the context state after encoding
            assertTrue(context.eof); // EOF should be set to true
            assertEquals(0, context.pos); // No data should be written
        } catch (Exception e) {
            fail("Encoding should not throw an exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testEncodeWithInvalidModulus() {
        Base32 base32 = new Base32();
        byte[] input = { (byte) 0xFF };
        int inPos = 0;
        int inAvail = 1;
        Context context = new Context();
        context.eof = false; // Ensure EOF is false to enter the encoding logic
        context.modulus = 5; // Set an invalid modulus to trigger the exception

        try {
            base32.encode(input, inPos, inAvail, context);
            fail("Encoding should throw an IllegalStateException due to invalid modulus");
        } catch (IllegalStateException e) {
            assertEquals("Impossible modulus 5", e.getMessage());
        } catch (Exception e) {
            fail("Encoding should throw IllegalStateException: " + e.getMessage());
        }
    }

}