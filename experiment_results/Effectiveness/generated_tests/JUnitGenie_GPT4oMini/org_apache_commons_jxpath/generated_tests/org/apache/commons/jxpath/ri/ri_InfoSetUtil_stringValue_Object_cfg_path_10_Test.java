package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_InfoSetUtil_stringValue_Object_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testStringValueWithNullObject() {
        try {
            String result = InfoSetUtil.stringValue(null);
            assertEquals("", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithBooleanObject() {
        try {
            String resultTrue = InfoSetUtil.stringValue(Boolean.TRUE);
            assertEquals("true", resultTrue);
            
            String resultFalse = InfoSetUtil.stringValue(Boolean.FALSE);
            assertEquals("false", resultFalse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithNumberObject() {
        try {
            String resultInt = InfoSetUtil.stringValue(42);
            assertEquals("42", resultInt);

            String resultDouble = InfoSetUtil.stringValue(42.5);
            assertEquals("42.5", resultDouble);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithStringObject() {
        try {
            String result = InfoSetUtil.stringValue("Hello");
            assertEquals("Hello", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}