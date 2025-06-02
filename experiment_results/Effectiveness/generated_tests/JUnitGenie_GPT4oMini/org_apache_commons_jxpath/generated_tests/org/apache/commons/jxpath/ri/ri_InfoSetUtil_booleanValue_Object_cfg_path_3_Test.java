package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class ri_InfoSetUtil_booleanValue_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testBooleanValueWithNumber() {
        // Test case to cover the path where object is a Number and is not zero
        Object testObject = 5; // A Number that is not zero
        boolean result = InfoSetUtil.booleanValue(testObject);
        assertFalse(result); // Expecting false since 5 != 0
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithNegativeZero() {
        // Test case to cover the path where object is a Number and is negative zero
        Object testObject = -0.0; // A Number that is negative zero
        boolean result = InfoSetUtil.booleanValue(testObject);
        assertFalse(result); // Expecting false since -0.0 is treated as zero
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithNaN() {
        // Test case to cover the path where object is a Number and is NaN
        Object testObject = Double.NaN; // A Number that is NaN
        boolean result = InfoSetUtil.booleanValue(testObject);
        assertFalse(result); // Expecting false since NaN is not a valid number
    }

}