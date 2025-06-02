package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_InfoSetUtil_stringValue_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testStringValue_withString() {
        Object input = "Hello, World!";
        String expected = "Hello, World!";
        String result = InfoSetUtil.stringValue(input);
        assertEquals(expected, result);
    }

    // Additional test cases can be added here to cover other scenarios.

}