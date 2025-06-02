package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ri_InfoSetUtil_booleanValue_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testBooleanValueStringEmpty() {
        // Test case for an empty string which should return false
        String testString = "";
        boolean result = InfoSetUtil.booleanValue(testString);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueStringNotEmpty() {
        // Test case for a non-empty string which should return true
        String testString = "Non-empty string";
        boolean result = InfoSetUtil.booleanValue(testString);
        assertTrue(result);
    }


}