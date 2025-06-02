package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class ArrayUtils_toPrimitive_Short_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testToPrimitiveWithNullArray() {
        try {
            Short[] input = null;
            short[] result = ArrayUtils.toPrimitive(input);
            assertNull(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

}