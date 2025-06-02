package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class ri_InfoSetUtil_booleanValue_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testBooleanValueWithNumberZero() {
        try {
            // Test case where the object is a Number with value 0
            Object object = 0; // This is a Number
            boolean result = InfoSetUtil.booleanValue(object);
            assertFalse(result); // Expecting false since value is 0
        } catch (Exception e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

}