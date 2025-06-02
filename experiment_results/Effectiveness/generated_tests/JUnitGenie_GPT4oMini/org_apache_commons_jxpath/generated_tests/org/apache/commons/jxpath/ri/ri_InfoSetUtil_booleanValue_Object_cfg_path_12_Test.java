package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.Pointer;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ri_InfoSetUtil_booleanValue_Object_cfg_path_12_Test {


    @Test(timeout = 4000)
    public void testBooleanValueWithBoolean() {
        try {
            // Test with a Boolean object
            boolean result = InfoSetUtil.booleanValue(Boolean.TRUE);
            assertTrue(result); // Expecting true

        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }


}
