package org.apache.commons.lang3;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class BooleanUtils_or_boolean_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testOrWithTrueElement() {
        boolean[] input = {false, false, true};
        try {
            boolean result = BooleanUtils.or(input);
            assertTrue(result);
        } catch (Exception e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testOrWithAllFalse() {
        boolean[] input = {false, false, false};
        try {
            boolean result = BooleanUtils.or(input);
            assertTrue(!result);
        } catch (Exception e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

    @Test(expected = NullPointerException.class)
    public void testOrWithNullArray() {
        boolean[] input = null;
        try {
            BooleanUtils.or(input);
        } catch (Exception e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

}