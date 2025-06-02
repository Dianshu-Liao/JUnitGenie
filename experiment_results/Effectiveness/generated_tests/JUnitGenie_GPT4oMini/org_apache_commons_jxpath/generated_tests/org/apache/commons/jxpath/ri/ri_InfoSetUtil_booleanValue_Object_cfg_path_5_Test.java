package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ri_InfoSetUtil_booleanValue_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testBooleanValueWithBoolean() {
        // Test case for boolean input
        Object input = Boolean.TRUE;
        boolean result = InfoSetUtil.booleanValue(input);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithFalseBoolean() {
        // Test case for false boolean input
        Object input = Boolean.FALSE;
        boolean result = InfoSetUtil.booleanValue(input);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithNumber() {
        // Test case for a number input
        Object input = 5;
        boolean result = InfoSetUtil.booleanValue(input);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithZero() {
        // Test case for zero number input
        Object input = 0;
        boolean result = InfoSetUtil.booleanValue(input);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithNaN() {
        // Test case for NaN input
        Object input = Double.NaN;
        boolean result = InfoSetUtil.booleanValue(input);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithString() {
        // Test case for non-empty string input
        Object input = "Hello";
        boolean result = InfoSetUtil.booleanValue(input);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithEmptyString() {
        // Test case for empty string input
        Object input = "";
        boolean result = InfoSetUtil.booleanValue(input);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithNull() {
        // Test case for null input
        Object input = null;
        boolean result = InfoSetUtil.booleanValue(input);
        assertFalse(result);
    }

}