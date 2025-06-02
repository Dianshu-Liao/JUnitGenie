package org.apache.commons.lang3;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ObjectUtils_isEmpty_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsEmptyWithCharSequence() {
        try {
            CharSequence charSequence = "";
            boolean result = ObjectUtils.isEmpty(charSequence);
            assertTrue(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}