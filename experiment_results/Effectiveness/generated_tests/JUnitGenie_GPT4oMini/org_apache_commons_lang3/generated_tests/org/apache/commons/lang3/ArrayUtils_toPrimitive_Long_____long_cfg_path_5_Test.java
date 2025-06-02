package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_toPrimitive_Long_____long_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testToPrimitiveWithNullArray() {
        long[] result = ArrayUtils.toPrimitive((Long[]) null, 0L);
        assertArrayEquals(new long[]{}, result);
    }


}