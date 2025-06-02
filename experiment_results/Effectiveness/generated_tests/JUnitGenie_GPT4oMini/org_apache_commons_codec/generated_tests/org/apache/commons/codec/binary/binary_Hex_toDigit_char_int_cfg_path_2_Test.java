package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.DecoderException;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_Hex_toDigit_char_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToDigit_ValidHexCharacter() {
        try {
            // Accessing the protected static method using reflection
            java.lang.reflect.Method method = Hex.class.getDeclaredMethod("toDigit", char.class, int.class);
            method.setAccessible(true);
            
            // Test with a valid hexadecimal character
            int result = (int) method.invoke(null, 'A', 0);
            assertEquals(10, result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testToDigit_InvalidHexCharacter() {
        try {
            // Accessing the protected static method using reflection
            java.lang.reflect.Method method = Hex.class.getDeclaredMethod("toDigit", char.class, int.class);
            method.setAccessible(true);
            
            // Test with an invalid hexadecimal character
            method.invoke(null, 'G', 1);
            fail("Expected DecoderException was not thrown.");
        } catch (Exception e) {
            // Check if the exception is of type DecoderException
            assertTrue(e.getCause() instanceof DecoderException);
            assertEquals("Illegal hexadecimal character G at index 1", e.getCause().getMessage());
        }
    }


}