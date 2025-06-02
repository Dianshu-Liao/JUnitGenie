package org.apache.commons.lang3;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ObjectUtils_isEmpty_Object_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testIsEmptyWithNull() {
        // Test case for the input parameter being null
        boolean result = ObjectUtils.isEmpty(null);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithNonNullObject() {
        // Test case for the input parameter being a non-null object
        boolean result = ObjectUtils.isEmpty(new Object());
        assertTrue(!result);
    }

}