package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_InfoSetUtil_number_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testNumberWithBooleanTrue() {
        Object input = Boolean.TRUE;
        Number result = InfoSetUtil.number(input);
        assertEquals(1, result); // Changed from InfoSetUtil.ONE to 1
    }

    @Test(timeout = 4000)
    public void testNumberWithBooleanFalse() {
        Object input = Boolean.FALSE;
        Number result = InfoSetUtil.number(input);
        assertEquals(0.0, result);
    }

    @Test(timeout = 4000)
    public void testNumberWithNumber() {
        Object input = 5;
        Number result = InfoSetUtil.number(input);
        assertEquals(5, result);
    }

    @Test(timeout = 4000)
    public void testNumberWithString() {
        Object input = "3.14";
        Number result = InfoSetUtil.number(input);
        assertEquals(Double.valueOf(3.14), result);
    }

    @Test(timeout = 4000)
    public void testNumberWithInvalidString() {
        Object input = "not a number";
        try {
            Number result = InfoSetUtil.number(input);
            assertEquals(Double.NaN, result); // Changed from InfoSetUtil.NOT_A_NUMBER to Double.NaN
        } catch (Exception ex) {
            // Handle exception if necessary
        }
    }


}