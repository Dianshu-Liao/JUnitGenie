package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.DecoderException;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_Hex_toDigit_char_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToDigitThrowsDecoderException() {
        char illegalChar = 'G'; // An illegal hexadecimal character
        int index = 0; // The index of the character

        try {
            // Accessing the protected static method using reflection
            java.lang.reflect.Method method = Hex.class.getDeclaredMethod("toDigit", char.class, int.class);
            method.setAccessible(true);
            method.invoke(null, illegalChar, index);
            fail("Expected DecoderException to be thrown");
        } catch (IllegalArgumentException e) {
            // Verify the exception message
            String expectedMessage = "Illegal hexadecimal character " + illegalChar + " at index " + index;
            assertEquals(expectedMessage, e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception type: " + e.getClass().getName());
        }
    }


}