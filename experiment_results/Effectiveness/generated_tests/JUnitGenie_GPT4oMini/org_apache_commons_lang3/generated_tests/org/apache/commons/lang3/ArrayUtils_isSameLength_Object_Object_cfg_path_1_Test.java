package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_isSameLength_Object_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsSameLength_DifferentLengths() {
        Object array1 = new int[5]; // Length 5
        Object array2 = new int[3]; // Length 3

        try {
            boolean result = ArrayUtils.isSameLength(array1, array2);
            assertFalse(result); // Expecting false since lengths are different
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

}