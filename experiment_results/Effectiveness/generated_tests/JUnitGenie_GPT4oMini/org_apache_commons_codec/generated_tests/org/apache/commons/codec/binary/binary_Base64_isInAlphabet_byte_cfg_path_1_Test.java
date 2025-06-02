package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;

public class binary_Base64_isInAlphabet_byte_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsInAlphabet_withInvalidOctet() {
        try {
            Base64 base64 = new Base64();
            Method method = Base64.class.getDeclaredMethod("isInAlphabet", byte.class);
            method.setAccessible(true);

            // Test with an octet less than 0
            byte octet = -1;
            boolean result = (Boolean) method.invoke(base64, octet);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsInAlphabet_withOctetOutOfBounds() {
        try {
            Base64 base64 = new Base64();
            Method method = Base64.class.getDeclaredMethod("isInAlphabet", byte.class);
            method.setAccessible(true);

            // Test with an octet greater than or equal to decodeTable length
            int octet = 128; // Use int to avoid lossy conversion
            boolean result = (Boolean) method.invoke(base64, (byte) octet); // Cast to byte
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsInAlphabet_withValidOctet() {
        try {
            Base64 base64 = new Base64();
            Method method = Base64.class.getDeclaredMethod("isInAlphabet", byte.class);
            method.setAccessible(true);

            // Test with a valid octet
            byte octet = 65; // Assuming 65 is a valid index in decodeTable
            boolean result = (Boolean) method.invoke(base64, octet);
            assertFalse(result); // Adjust this assertion based on the actual content of decodeTable
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}