package org.apache.commons.lang3;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class BooleanUtils_or_boolean_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testOrWithEmptyArray() {
        try {
            boolean result = BooleanUtils.or(new boolean[]{});
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

}