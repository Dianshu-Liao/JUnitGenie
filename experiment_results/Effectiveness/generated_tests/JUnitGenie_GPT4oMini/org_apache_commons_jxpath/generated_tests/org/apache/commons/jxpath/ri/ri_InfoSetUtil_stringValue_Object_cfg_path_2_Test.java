package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_InfoSetUtil_stringValue_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testStringValueWithNumber() {
        Object input = 123.45; // A Number instance
        String expected = "123.45"; // Expected output
        String actual = InfoSetUtil.stringValue(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testStringValueWithInteger() {
        Object input = 123; // An Integer instance
        String expected = "123"; // Expected output
        String actual = InfoSetUtil.stringValue(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testStringValueWithBooleanTrue() {
        Object input = true; // A Boolean instance
        String expected = "true"; // Expected output
        String actual = InfoSetUtil.stringValue(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testStringValueWithBooleanFalse() {
        Object input = false; // A Boolean instance
        String expected = "false"; // Expected output
        String actual = InfoSetUtil.stringValue(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testStringValueWithNull() {
        Object input = null; // Null input
        String expected = ""; // Expected output
        String actual = InfoSetUtil.stringValue(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testStringValueWithString() {
        Object input = "Hello"; // A String instance
        String expected = "Hello"; // Expected output
        String actual = InfoSetUtil.stringValue(input);
        assertEquals(expected, actual);
    }

}