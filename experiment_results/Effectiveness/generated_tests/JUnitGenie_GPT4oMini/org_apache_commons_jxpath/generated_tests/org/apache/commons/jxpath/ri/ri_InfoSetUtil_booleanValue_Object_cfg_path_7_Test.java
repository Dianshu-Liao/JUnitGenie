package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ri_InfoSetUtil_booleanValue_Object_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testBooleanValueWithNonEmptyString() {
        String testString = "Hello";
        boolean result = InfoSetUtil.booleanValue(testString);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithEmptyString() {
        String testString = "";
        boolean result = InfoSetUtil.booleanValue(testString);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithNumber() {
        Double testNumber = 5.0;
        boolean result = InfoSetUtil.booleanValue(testNumber);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithZero() {
        Double testNumber = 0.0;
        boolean result = InfoSetUtil.booleanValue(testNumber);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithNaN() {
        Double testNumber = Double.NaN;
        boolean result = InfoSetUtil.booleanValue(testNumber);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithBooleanTrue() {
        Boolean testBoolean = true;
        boolean result = InfoSetUtil.booleanValue(testBoolean);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithBooleanFalse() {
        Boolean testBoolean = false;
        boolean result = InfoSetUtil.booleanValue(testBoolean);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithNull() {
        Object testObject = null;
        boolean result = InfoSetUtil.booleanValue(testObject);
        assertFalse(result);
    }

}