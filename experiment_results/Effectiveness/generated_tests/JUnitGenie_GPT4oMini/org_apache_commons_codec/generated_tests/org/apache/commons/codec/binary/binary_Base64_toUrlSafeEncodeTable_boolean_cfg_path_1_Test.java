package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class binary_Base64_toUrlSafeEncodeTable_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToUrlSafeEncodeTableFalse() {
        try {
            Method method = Base64.class.getDeclaredMethod("toUrlSafeEncodeTable", boolean.class);
            method.setAccessible(true);
            byte[] result = (byte[]) method.invoke(null, false);
            // Use a public method or a different way to get the expected value
            byte[] expected = Base64.encodeBase64String("test".getBytes()).getBytes(); // Example expected value
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testToUrlSafeEncodeTableTrue() {
        try {
            Method method = Base64.class.getDeclaredMethod("toUrlSafeEncodeTable", boolean.class);
            method.setAccessible(true);
            byte[] result = (byte[]) method.invoke(null, true);
            // Assuming URL_SAFE_ENCODE_TABLE is defined similarly to STANDARD_ENCODE_TABLE
            // You would need to define URL_SAFE_ENCODE_TABLE for this test to be valid
            byte[] expected = Base64.encodeBase64URLSafeString("test".getBytes()).getBytes(); // Example expected value
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}