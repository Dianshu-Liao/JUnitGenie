package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.Hex;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class binary_Hex_toAlphabet_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToAlphabetWithToLowerCase() {
        try {
            Method method = Hex.class.getDeclaredMethod("toAlphabet", boolean.class);
            method.setAccessible(true);
            char[] expected = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            char[] actual = (char[]) method.invoke(null, true);
            assertArrayEquals(expected, actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}