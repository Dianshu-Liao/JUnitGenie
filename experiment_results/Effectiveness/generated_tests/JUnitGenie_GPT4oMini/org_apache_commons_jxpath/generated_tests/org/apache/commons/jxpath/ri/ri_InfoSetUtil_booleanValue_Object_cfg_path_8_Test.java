package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class ri_InfoSetUtil_booleanValue_Object_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testBooleanValueWithNumberZero() {
        Object input = 0; // This is a Number and should return false
        boolean result = InfoSetUtil.booleanValue(input);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithNumberNegativeZero() {
        Object input = -0.0; // This is a Number and should return false
        boolean result = InfoSetUtil.booleanValue(input);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithBooleanFalse() {
        Object input = Boolean.FALSE; // This is a Boolean and should return false
        boolean result = InfoSetUtil.booleanValue(input);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithStringEmpty() {
        Object input = ""; // This is a String and should return false
        boolean result = InfoSetUtil.booleanValue(input);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithNull() {
        Object input = null; // This should return false
        boolean result = InfoSetUtil.booleanValue(input);
        assertFalse(result);
    }

}