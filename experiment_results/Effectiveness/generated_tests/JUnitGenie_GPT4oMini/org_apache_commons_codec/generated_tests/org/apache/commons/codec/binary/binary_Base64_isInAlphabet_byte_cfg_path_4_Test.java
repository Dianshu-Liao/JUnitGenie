package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;

public class binary_Base64_isInAlphabet_byte_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testIsInAlphabetWithNegativeOctet() {
        Base64 base64 = new Base64();
        try {
            Method method = Base64.class.getDeclaredMethod("isInAlphabet", byte.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(base64, (byte) -1);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}