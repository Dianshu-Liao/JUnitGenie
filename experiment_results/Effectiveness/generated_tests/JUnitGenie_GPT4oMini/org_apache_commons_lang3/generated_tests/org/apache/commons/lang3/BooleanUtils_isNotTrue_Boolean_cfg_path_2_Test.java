package org.apache.commons.lang3;
import org.apache.commons.lang3.BooleanUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class BooleanUtils_isNotTrue_Boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsNotTrueWithNull() {
        // Test case where bool is null
        Boolean bool = null;
        try {
            boolean result = BooleanUtils.isNotTrue(bool);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsNotTrueWithFalse() {
        // Test case where bool is false
        Boolean bool = Boolean.FALSE;
        try {
            boolean result = BooleanUtils.isNotTrue(bool);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsNotTrueWithTrue() {
        // Test case where bool is true
        Boolean bool = Boolean.TRUE;
        try {
            boolean result = BooleanUtils.isNotTrue(bool);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

}