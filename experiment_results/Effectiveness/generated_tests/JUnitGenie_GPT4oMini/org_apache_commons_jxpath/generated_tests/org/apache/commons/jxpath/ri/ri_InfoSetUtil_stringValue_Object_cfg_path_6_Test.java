package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_InfoSetUtil_stringValue_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testStringValueWithString() {
        Object input = "testString";
        String result = InfoSetUtil.stringValue(input);
        assertEquals("testString", result);
    }

    @Test(timeout = 4000)
    public void testStringValueWithNumber() {
        Object input = 123.45;
        String result = InfoSetUtil.stringValue(input);
        assertEquals("123.45", result);
    }

    @Test(timeout = 4000)
    public void testStringValueWithBooleanTrue() {
        Object input = true;
        String result = InfoSetUtil.stringValue(input);
        assertEquals("true", result);
    }

    @Test(timeout = 4000)
    public void testStringValueWithBooleanFalse() {
        Object input = false;
        String result = InfoSetUtil.stringValue(input);
        assertEquals("false", result);
    }

    @Test(timeout = 4000)
    public void testStringValueWithNull() {
        Object input = null;
        String result = InfoSetUtil.stringValue(input);
        assertEquals("", result);
    }


    // The following test has been commented out due to missing EvalContext and Pointer classes
    

    @Test(timeout = 4000)
    public void testStringValueWithOtherObject() {
        Object input = new Object();
        String result = InfoSetUtil.stringValue(input);
        assertEquals(input.toString(), result);
    }


}
