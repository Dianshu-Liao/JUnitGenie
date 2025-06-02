package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.apache.commons.jxpath.ri.model.NodePointer;

public class ri_InfoSetUtil_stringValue_Object_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testStringValueWithString() {
        Object input = "testString";
        String expected = "testString";
        String result = InfoSetUtil.stringValue(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testStringValueWithNumber() {
        Object input = 123.45;
        String expected = "123.45";
        String result = InfoSetUtil.stringValue(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testStringValueWithBooleanTrue() {
        Object input = true;
        String expected = "true";
        String result = InfoSetUtil.stringValue(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testStringValueWithBooleanFalse() {
        Object input = false;
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
    public void testStringValueWithOtherObject() {
        Object input = new Object();
        String expected = input.toString();
        String result = InfoSetUtil.stringValue(input);
        assertEquals(expected, result);
    }


}
