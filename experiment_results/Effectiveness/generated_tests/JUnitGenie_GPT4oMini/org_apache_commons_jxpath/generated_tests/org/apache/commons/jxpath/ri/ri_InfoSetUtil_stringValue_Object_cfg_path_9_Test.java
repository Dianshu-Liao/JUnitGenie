package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import javax.xml.namespace.QName;

public class ri_InfoSetUtil_stringValue_Object_cfg_path_9_Test {


    @Test(timeout = 4000)
    public void testStringValueWithString() {
        try {
            String result = InfoSetUtil.stringValue("Hello World");
            assertEquals("Hello World", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithNumber() {
        try {
            String result = InfoSetUtil.stringValue(42);
            assertEquals("42", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithBoolean() {
        try {
            String result = InfoSetUtil.stringValue(true);
            assertEquals("true", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testStringValueWithNull() {
        try {
            String result = InfoSetUtil.stringValue(null);
            assertEquals("", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
