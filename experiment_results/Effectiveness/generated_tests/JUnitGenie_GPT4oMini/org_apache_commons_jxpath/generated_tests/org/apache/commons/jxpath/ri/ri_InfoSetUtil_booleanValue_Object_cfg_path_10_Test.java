package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.VariablePointer;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_InfoSetUtil_booleanValue_Object_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testBooleanValueWithBoolean() {
        // Test case for boolean input
        Object input = Boolean.TRUE;
        boolean result = InfoSetUtil.booleanValue(input);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithNonBoolean() {
        // Test case for non-boolean input
        Object input = new Object();
        boolean result = InfoSetUtil.booleanValue(input);
        assertFalse(result);
    }


    @Test(timeout = 4000)
    public void testBooleanValueWithEmptyString() {
        // Test case for empty string input
        Object input = "";
        boolean result = InfoSetUtil.booleanValue(input);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithNonEmptyString() {
        // Test case for non-empty string input
        Object input = "Hello";
        boolean result = InfoSetUtil.booleanValue(input);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithNull() {
        // Test case for null input
        Object input = null;
        boolean result = InfoSetUtil.booleanValue(input);
        assertFalse(result);
    }


}
