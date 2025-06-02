package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_InfoSetUtil_number_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testNumberWithBooleanFalse() {
        Object input = Boolean.FALSE;
        Number result = InfoSetUtil.number(input);
        // Use a public constant or method to compare with result
        assertEquals(0, result.intValue()); // Assuming ZERO is equivalent to 0
    }


}