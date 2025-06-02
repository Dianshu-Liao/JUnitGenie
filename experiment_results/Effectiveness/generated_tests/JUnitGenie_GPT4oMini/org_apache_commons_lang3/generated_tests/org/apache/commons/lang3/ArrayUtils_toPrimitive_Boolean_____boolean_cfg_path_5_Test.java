package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class ArrayUtils_toPrimitive_Boolean_____boolean_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testToPrimitive_arrayIsNull() {
        try {
            Boolean[] inputArray = null;
            boolean valueForNull = false;
            boolean[] result = ArrayUtils.toPrimitive(inputArray, valueForNull);
            assertNull(result);
        } catch (Exception e) {
            // Handle the exception thrown by the focal method
            e.printStackTrace();
        }
    }

}