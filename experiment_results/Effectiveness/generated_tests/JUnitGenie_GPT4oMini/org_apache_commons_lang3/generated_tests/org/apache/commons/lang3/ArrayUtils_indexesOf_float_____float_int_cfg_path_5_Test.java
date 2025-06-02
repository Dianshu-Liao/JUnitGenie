package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import java.util.BitSet;
import static org.junit.Assert.*;

public class ArrayUtils_indexesOf_float_____float_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testIndexesOf_NullArray() {
        // Arrange
        float[] array = null;
        float valueToFind = 1.0f;
        int startIndex = 0;

        // Act
        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);

        // Assert
        assertNotNull(result);
        assertEquals(0, result.length());
    }

    @Test(timeout = 4000)
    public void testIndexesOf_EmptyArray() {
        // Arrange
        float[] array = new float[0];
        float valueToFind = 1.0f;
        int startIndex = 0;

        // Act
        BitSet result = ArrayUtils.indexesOf(array, valueToFind, startIndex);

        // Assert
        assertNotNull(result);
        assertEquals(0, result.length());
    }

    // Further test cases can be added here, for example, cases with a non-empty array.

}