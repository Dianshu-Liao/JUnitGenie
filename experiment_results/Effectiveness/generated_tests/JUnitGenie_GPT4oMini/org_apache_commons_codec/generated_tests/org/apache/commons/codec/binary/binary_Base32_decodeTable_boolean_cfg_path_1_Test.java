package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base32;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class binary_Base32_decodeTable_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testDecodeTableWithUseHexFalse() {
        try {
            // Accessing the private static method using reflection
            java.lang.reflect.Method method = Base32.class.getDeclaredMethod("decodeTable", boolean.class);
            method.setAccessible(true);
            
            // Call the method with useHex = false
            byte[] result = (byte[]) method.invoke(null, false);
            
            // Expected DECODE_TABLE
            byte[] expected = {
                // 0   1   2   3   4   5   6   7   8   9   A   B   C   D   E   F
                // 00-0f
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                // 10-1f
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                // 20-2f
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                // 30-3f
                -1, -1, -1, 26, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1,
                // 40-4f
                -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
                // 50-5a
                14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1,
                // 60-6f
                -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
                // 70-7a
                14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25
            };
            
            // Assert that the result matches the expected DECODE_TABLE
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}