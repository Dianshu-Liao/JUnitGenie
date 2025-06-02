package org.apache.commons.lang3;
import org.apache.commons.lang3.BooleanUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class BooleanUtils_toIntegerObject_Boolean_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testToIntegerObject_NullInput() {
        try {
            // Test case for the path where bool is null
            Integer result = BooleanUtils.toIntegerObject(null);
            assertNull(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}