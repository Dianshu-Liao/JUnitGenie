package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.VariablePointer;
import org.apache.commons.jxpath.ri.EvalContext;
import org.junit.Test;
import static org.junit.Assert.*;

public class ri_InfoSetUtil_booleanValue_Object_cfg_path_11_Test {

    
    @Test(timeout = 4000)
    public void testBooleanValueWithNumber() {
        Object number = 42; // Testing with a valid Number
        boolean result = InfoSetUtil.booleanValue(number);
        assertTrue(result); // 42 is not equal to 0
    }

    @Test(timeout = 4000)
    public void testBooleanValueWithEmptyString() {
        String emptyString = "";
        boolean result = InfoSetUtil.booleanValue(emptyString);
        assertFalse(result); // empty string should return false
    }
    
    @Test(timeout = 4000)
    public void testBooleanValueWithBoolean() {
        boolean resultTrue = InfoSetUtil.booleanValue(Boolean.TRUE);
        assertTrue(resultTrue); // true should return true

        boolean resultFalse = InfoSetUtil.booleanValue(Boolean.FALSE);
        assertFalse(resultFalse); // false should return false
    }
    
    @Test(timeout = 4000)
    public void testBooleanValueWithNull() {
        boolean result = InfoSetUtil.booleanValue(null);
        assertFalse(result); // null should return false
    }


}
