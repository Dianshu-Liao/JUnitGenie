package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class ri_InfoSetUtil_booleanValue_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testBooleanValueWithNumberNotZero() {
        Object testObject = 5; // A Number that is not zero
        boolean result = InfoSetUtil.booleanValue(testObject);
        assertFalse(result); // Expecting false since 5 != 0
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithNegativeZero() {
        Object testObject = -0.0; // A Number that is negative zero
        boolean result = InfoSetUtil.booleanValue(testObject);
        assertFalse(result); // Expecting false since value is negZero
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithNaN() {
        Object testObject = Double.NaN; // A Number that is NaN
        boolean result = InfoSetUtil.booleanValue(testObject);
        assertFalse(result); // Expecting false since value is NaN
    }

}