package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_InfoSetUtil_stringValue_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testStringValueWithBooleanFalse() {
        Object input = Boolean.FALSE;
        String expected = "false";
        String actual = InfoSetUtil.stringValue(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testStringValueWithBooleanTrue() {
        Object input = Boolean.TRUE;
        String expected = "true";
        String actual = InfoSetUtil.stringValue(input);
        assertEquals(expected, actual);
    }

}