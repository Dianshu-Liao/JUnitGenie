package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class ArrayUtils_toObject_double_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testToObjectWithNullArray() {
        try {
            // Explicitly specify the type to avoid ambiguity
            Double[] result = ArrayUtils.toObject((double[]) null);
            assertNull(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }


}