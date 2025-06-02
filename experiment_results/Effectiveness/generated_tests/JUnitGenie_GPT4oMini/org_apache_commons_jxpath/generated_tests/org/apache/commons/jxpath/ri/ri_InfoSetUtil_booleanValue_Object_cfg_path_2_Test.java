package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ri_InfoSetUtil_booleanValue_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testBooleanValue_WithNumber_NonZero() {
        Object testObject = 5; // Non-zero number
        boolean result = InfoSetUtil.booleanValue(testObject);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValue_WithNumber_Zero() {
        Object testObject = 0; // Zero
        boolean result = InfoSetUtil.booleanValue(testObject);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValue_WithNumber_NegZero() {
        Object testObject = -0.0; // Negative zero
        boolean result = InfoSetUtil.booleanValue(testObject);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValue_WithNaN() {
        Object testObject = Double.NaN; // NaN value
        boolean result = InfoSetUtil.booleanValue(testObject);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValue_WithBooleanTrue() {
        Object testObject = Boolean.TRUE; // Boolean true
        boolean result = InfoSetUtil.booleanValue(testObject);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValue_WithBooleanFalse() {
        Object testObject = Boolean.FALSE; // Boolean false
        boolean result = InfoSetUtil.booleanValue(testObject);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValue_WithNonEmptyString() {
        Object testObject = "Hello"; // Non-empty string
        boolean result = InfoSetUtil.booleanValue(testObject);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValue_WithEmptyString() {
        Object testObject = ""; // Empty string
        boolean result = InfoSetUtil.booleanValue(testObject);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValue_WithNull() {
        Object testObject = null; // Null value
        boolean result = InfoSetUtil.booleanValue(testObject);
        assertFalse(result);
    }

}