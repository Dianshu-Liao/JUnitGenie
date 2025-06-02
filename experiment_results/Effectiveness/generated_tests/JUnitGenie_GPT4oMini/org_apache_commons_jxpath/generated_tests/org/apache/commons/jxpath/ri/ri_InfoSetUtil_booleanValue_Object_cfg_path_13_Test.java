package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.Pointer;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ri_InfoSetUtil_booleanValue_Object_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testBooleanValueWithBoolean() {
        // Test case for a non-null Boolean instance
        Object input = Boolean.TRUE;
        boolean result = InfoSetUtil.booleanValue(input);
        assertTrue(result);
    }



}
