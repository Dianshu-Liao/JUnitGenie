package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_double_____double_____cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        // Given
        double[] array = {1.0, 2.0, 3.0};
        double[] values = {}; // Empty values array to satisfy the isEmpty check

        // When
        double[] result = ArrayUtils.removeElements(array, values);

        // Then
        assertArrayEquals(new double[]{1.0, 2.0, 3.0}, result, 0.0);
    }

}