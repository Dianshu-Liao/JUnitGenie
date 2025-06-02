package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base32;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class binary_Base32_decodeTable_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testDecodeTableWithUseHexTrue() {
        try {
            // Accessing the private static method using reflection
            Base32 base32 = new Base32(); // Create an instance of Base32
            byte[] result = (byte[]) Base32.class.getDeclaredMethod("decodeTable", boolean.class)
                    .invoke(base32, true); // Use the instance to invoke the method
            // Use reflection to access the private HEX_DECODE_TABLE
            byte[] expected = (byte[]) Base32.class.getDeclaredField("HEX_DECODE_TABLE").get(null);
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDecodeTableWithUseHexFalse() {
        try {
            // Accessing the private static method using reflection
            Base32 base32 = new Base32(); // Create an instance of Base32
            byte[] result = (byte[]) Base32.class.getDeclaredMethod("decodeTable", boolean.class)
                    .invoke(base32, false); // Use the instance to invoke the method
            // Use reflection to access the private DECODE_TABLE
            byte[] expected = (byte[]) Base32.class.getDeclaredField("DECODE_TABLE").get(null);
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}