package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArrayUtils_isSameLength_Object_____Object_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsSameLength() {
        // Test case where both arrays have the same length
        Object[] array1 = new Object[3];
        Object[] array2 = new Object[3];
        assertTrue(ArrayUtils.isSameLength(array1, array2));

        // Test case where the first array is longer than the second
        Object[] array3 = new Object[4];
        Object[] array4 = new Object[2];
        assertFalse(ArrayUtils.isSameLength(array3, array4));

        // Test case where the second array is longer than the first
        Object[] array5 = new Object[1];
        Object[] array6 = new Object[5];
        assertFalse(ArrayUtils.isSameLength(array5, array6));

        // Test case where both arrays are null
        Object[] array7 = null;
        Object[] array8 = null;
        assertTrue(ArrayUtils.isSameLength(array7, array8));

        // Test case where one array is null and the other is not
        Object[] array9 = null;
        Object[] array10 = new Object[2];
        assertFalse(ArrayUtils.isSameLength(array9, array10));
    }

}