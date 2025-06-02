package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class ArrayUtils_toPrimitive_Byte_____byte_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testToPrimitiveWithNullArray() {
        try {
            // Correctly specify the type for the toPrimitive method
            Byte[] input = null;
            byte[] result = ArrayUtils.toPrimitive(input, (byte) 0);
            assertNull(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }


}