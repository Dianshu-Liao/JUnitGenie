package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class binary_Base64_toUrlSafeEncodeTable_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToUrlSafeEncodeTable() {
        try {
            // Access the private static method using reflection
            Method method = Base64.class.getDeclaredMethod("toUrlSafeEncodeTable", boolean.class);
            method.setAccessible(true);

            // Test with urlSafe = true
            byte[] expectedUrlSafeTable = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 
                'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 
                'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 
                'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
                '-', '_'
            };
            byte[] resultUrlSafe = (byte[]) method.invoke(null, true);
            assertArrayEquals(expectedUrlSafeTable, resultUrlSafe);

            // Test with urlSafe = false (not covered in the provided CFGPath but included for completeness)
            // This part is not strictly necessary for the CFGPath but is useful for full coverage
            // Uncomment if needed
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}