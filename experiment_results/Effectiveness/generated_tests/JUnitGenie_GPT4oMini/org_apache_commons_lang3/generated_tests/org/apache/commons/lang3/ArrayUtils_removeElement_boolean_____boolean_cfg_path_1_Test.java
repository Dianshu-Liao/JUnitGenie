package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElement_boolean_____boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRemoveElement_clone() {
        // Given
        boolean[] originalArray = new boolean[]{true, false, true};
        boolean elementToRemove = false;

        // When
        boolean[] resultArray = ArrayUtils.removeElement(originalArray, elementToRemove);

        // Then
        boolean[] expectedArray = new boolean[]{true, true}; // expected behavior after removal
        assertArrayEquals(expectedArray, resultArray);
    }

}