package org.apache.commons.codec.binary;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_Hex_decode_Object_cfg_path_4_Test {

    private Hex hex = new Hex();

    @Test(timeout = 4000)
    public void testDecodeHexValidInput() {
        char[] validHex = "1A3F".toCharArray(); // even length and valid hex characters
        try {
            // Correcting the type casting issue by using the decode method that returns an Object
            byte[] result = (byte[]) hex.decode(validHex);
            assertNotNull(result); // Asserting that the result is not null
            assertTrue(result instanceof byte[]); // The result should be a byte array
        } catch (DecoderException e) {
            fail("Expected no DecoderException to be thrown");
        }
    }

    @Test(timeout = 4000)
    public void testDecodeHexNullInput() {
        try {
            hex.decode((char[]) null); // Correctly passing null as char[] to avoid ambiguity
            fail("Expected DecoderException to be thrown");
        } catch (DecoderException e) {
            assertEquals("Cannot decode null", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testDecodeHexOddLengthInput() {
        char[] oddLengthHex = "1A3".toCharArray(); // odd length
        try {
            hex.decode(oddLengthHex);
            fail("Expected DecoderException to be thrown");
        } catch (DecoderException e) {
            assertEquals("Odd number of characters", e.getMessage()); // Check for the correct message
        }
    }

    @Test(timeout = 4000)
    public void testDecodeHexInvalidCharacterInput() {
        char[] invalidHex = "1A3G".toCharArray(); // 'G' is not a valid hex character
        try {
            hex.decode(invalidHex);
            fail("Expected DecoderException to be thrown");
        } catch (DecoderException e) {
            assertEquals("Invalid hexadecimal character", e.getMessage()); // Check for the correct message
        }
    }


}