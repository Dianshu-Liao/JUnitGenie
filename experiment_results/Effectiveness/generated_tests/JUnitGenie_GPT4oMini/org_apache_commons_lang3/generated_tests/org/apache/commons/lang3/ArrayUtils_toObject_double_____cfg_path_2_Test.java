package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_toObject_double_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToObjectWithEmptyArray() {
        // Given
        double[] inputArray = new double[0];

        // When
        Double[] result = ArrayUtils.toObject(inputArray);

        // Then
        assertArrayEquals(ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY, result);
    }

    @Test(timeout = 4000)
    public void testToObjectWithNullArray() {
        // Given
        double[] inputArray = null;

        // When
        Double[] result = ArrayUtils.toObject(inputArray);

        // Then
        assertArrayEquals(null, result);
    }

}