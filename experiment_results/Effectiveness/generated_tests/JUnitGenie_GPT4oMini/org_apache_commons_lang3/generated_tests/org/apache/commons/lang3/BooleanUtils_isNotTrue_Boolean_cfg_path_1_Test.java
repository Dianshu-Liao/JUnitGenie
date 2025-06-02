package org.apache.commons.lang3;
import org.apache.commons.lang3.BooleanUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class BooleanUtils_isNotTrue_Boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsNotTrueWithFalse() {
        // Test case where bool is false
        Boolean bool = false;
        boolean result = BooleanUtils.isNotTrue(bool);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsNotTrueWithNull() {
        // Test case where bool is null
        Boolean bool = null;
        boolean result = BooleanUtils.isNotTrue(bool);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsNotTrueWithTrue() {
        // Test case where bool is true
        Boolean bool = true;
        boolean result = BooleanUtils.isNotTrue(bool);
        assertFalse(result);
    }

}