package org.apache.commons.lang3;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BooleanUtils_or_boolean_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testOrWithNullArray() {
        try {
            // This should throw an exception since the array is null
            BooleanUtils.or((boolean[]) null); // Explicitly cast to boolean[]
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testOrWithEmptyArray() {
        boolean[] emptyArray = new boolean[0];
        assertFalse(BooleanUtils.or(emptyArray));
    }

    @Test(timeout = 4000)
    public void testOrWithAllFalse() {
        boolean[] allFalseArray = {false, false, false};
        assertFalse(BooleanUtils.or(allFalseArray));
    }

    @Test(timeout = 4000)
    public void testOrWithAtLeastOneTrue() {
        boolean[] mixedArray = {false, true, false};
        assertTrue(BooleanUtils.or(mixedArray));
    }


}