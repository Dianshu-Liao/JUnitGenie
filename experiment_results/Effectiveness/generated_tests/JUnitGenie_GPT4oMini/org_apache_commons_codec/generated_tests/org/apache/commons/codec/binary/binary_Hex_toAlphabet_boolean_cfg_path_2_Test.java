package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Hex;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class binary_Hex_toAlphabet_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToAlphabetUpperCase() {
        try {
            // Access the private static method using reflection
            Method method = Hex.class.getDeclaredMethod("toAlphabet", boolean.class);
            method.setAccessible(true);
            
            // Call the method with toLowerCase = false
            char[] result = (char[]) method.invoke(null, false);
            
            // Expected result
            char[] expected = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            
            // Assert the result
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}