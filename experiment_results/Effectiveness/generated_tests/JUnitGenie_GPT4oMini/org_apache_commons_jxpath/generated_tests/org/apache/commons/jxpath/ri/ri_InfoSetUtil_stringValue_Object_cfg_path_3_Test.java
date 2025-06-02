package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_InfoSetUtil_stringValue_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testStringValueWithNumber() {
        // Test with a Number that is an integer
        Number number = 5;
        String result = InfoSetUtil.stringValue(number);
        assertEquals("5", result);

        // Test with a Number that is a double
        number = 5.5;
        result = InfoSetUtil.stringValue(number);
        assertEquals("5.5", result);
    }

    @Test(timeout = 4000)
    public void testStringValueWithString() {
        // Test with a String
        String str = "Hello";
        String result = InfoSetUtil.stringValue(str);
        assertEquals("Hello", result);
    }

    @Test(timeout = 4000)
    public void testStringValueWithBoolean() {
        // Test with a Boolean true
        Boolean boolTrue = true;
        String result = InfoSetUtil.stringValue(boolTrue);
        assertEquals("true", result);

        // Test with a Boolean false
        Boolean boolFalse = false;
        result = InfoSetUtil.stringValue(boolFalse);
        assertEquals("false", result);
    }

    @Test(timeout = 4000)
    public void testStringValueWithNull() {
        // Test with null
        Object obj = null;
        String result = InfoSetUtil.stringValue(obj);
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testStringValueWithOtherObject() {
        // Test with an Object that is not handled specifically
        Object obj = new Object();
        String result = InfoSetUtil.stringValue(obj);
        assertEquals(obj.toString(), result);
    }

}