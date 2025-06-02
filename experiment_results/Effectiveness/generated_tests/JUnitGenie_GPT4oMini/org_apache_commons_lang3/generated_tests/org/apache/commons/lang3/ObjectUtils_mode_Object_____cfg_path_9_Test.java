package org.apache.commons.lang3;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class ObjectUtils_mode_Object_____cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testModeWithEmptyArray() {
        try {
            Object result = ObjectUtils.mode(new Object[]{});
            assertNull(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testModeWithNullArray() {
        try {
            Object result = ObjectUtils.mode(null);
            assertNull(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}