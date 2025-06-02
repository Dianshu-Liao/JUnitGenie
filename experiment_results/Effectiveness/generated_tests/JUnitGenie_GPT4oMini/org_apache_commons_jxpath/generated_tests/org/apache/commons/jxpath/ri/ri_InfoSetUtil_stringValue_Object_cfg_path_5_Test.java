package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_InfoSetUtil_stringValue_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testStringValueWithBooleanTrue() {
        Object input = Boolean.TRUE;
        String expected = "true";
        
        String result = InfoSetUtil.stringValue(input);
        
        assertEquals(expected, result);
    }
    
    @Test(timeout = 4000)
    public void testStringValueWithBooleanFalse() {
        Object input = Boolean.FALSE;
        String expected = "false";
        
        String result = InfoSetUtil.stringValue(input);
        
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testStringValueWithNull() {
        Object input = null;
        String expected = "";
        
        String result = InfoSetUtil.stringValue(input);
        
        assertEquals(expected, result);
    }
    
    @Test(timeout = 4000)
    public void testStringValueWithString() {
        Object input = "test";
        String expected = "test";
        
        String result = InfoSetUtil.stringValue(input);
        
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testStringValueWithInteger() {
        Object input = 42;
        String expected = "42";
        
        String result = InfoSetUtil.stringValue(input);
        
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testStringValueWithDouble() {
        Object input = 42.0;
        String expected = "42.0";
        
        String result = InfoSetUtil.stringValue(input);
        
        assertEquals(expected, result);
    }

}