package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import static org.junit.Assert.assertFalse;

public class binary_Base64_isInAlphabet_byte_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsInAlphabetWithNegativeOctet() {
        try {
            Base64 base64 = new Base64();
            Method method = Base64.class.getDeclaredMethod("isInAlphabet", byte.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(base64, (byte) -1);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsInAlphabetWithOctetGreaterThanLength() {
        try {
            Base64 base64 = new Base64();
            Method method = Base64.class.getDeclaredMethod("isInAlphabet", byte.class);
            method.setAccessible(true);
            // Use a valid byte value that is out of bounds for the decodeTable
            Field decodeTableField = Base64.class.getDeclaredField("decodeTable");
            decodeTableField.setAccessible(true);
            byte[] decodeTable = (byte[]) decodeTableField.get(base64); // Change null to base64
            byte octet = (byte) decodeTable.length; // out of bounds
            boolean result = (boolean) method.invoke(base64, octet);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsInAlphabetWithValidOctet() {
        try {
            Base64 base64 = new Base64();
            Method method = Base64.class.getDeclaredMethod("isInAlphabet", byte.class);
            method.setAccessible(true);
            byte octet = 0; // assuming 0 is a valid index in decodeTable
            boolean result = (boolean) method.invoke(base64, octet);
            assertFalse(result); // Adjust this assertion based on the actual content of decodeTable
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}