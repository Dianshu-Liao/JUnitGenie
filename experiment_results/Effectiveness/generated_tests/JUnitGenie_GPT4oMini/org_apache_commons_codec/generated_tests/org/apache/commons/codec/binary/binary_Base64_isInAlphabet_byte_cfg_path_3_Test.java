package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class binary_Base64_isInAlphabet_byte_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsInAlphabetWithNegativeOctet() {
        try {
            Base64 base64 = new Base64();
            // Accessing the protected method using reflection
            java.lang.reflect.Method method = Base64.class.getDeclaredMethod("isInAlphabet", byte.class);
            method.setAccessible(true);
            boolean result = (Boolean) method.invoke(base64, (byte) -1);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsInAlphabetWithOctetGreaterThanLength() {
        try {
            Base64 base64 = new Base64();
            // Accessing the protected method using reflection
            java.lang.reflect.Method method = Base64.class.getDeclaredMethod("isInAlphabet", byte.class);
            method.setAccessible(true);
            // Assuming decodeTable has a length of 64 for Base64 encoding
            boolean result = (Boolean) method.invoke(base64, (byte) 64);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}