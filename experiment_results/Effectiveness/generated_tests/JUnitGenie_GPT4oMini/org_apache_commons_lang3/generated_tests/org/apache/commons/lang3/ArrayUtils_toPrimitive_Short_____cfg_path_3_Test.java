package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_toPrimitive_Short_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testToPrimitiveWithEmptyArray() {
        // Given
        Short[] input = new Short[0];

        // When
        short[] result = ArrayUtils.toPrimitive(input);

        // Then
        assertArrayEquals(new short[]{}, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithNullArray() {
        // Given
        Short[] input = null;

        // When
        short[] result = ArrayUtils.toPrimitive(input);

        // Then
        assertArrayEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithNonEmptyArray() {
        // Given
        Short[] input = new Short[]{1, 2, 3};

        // When
        short[] result = ArrayUtils.toPrimitive(input);

        // Then
        assertArrayEquals(new short[]{1, 2, 3}, result);
    }

}