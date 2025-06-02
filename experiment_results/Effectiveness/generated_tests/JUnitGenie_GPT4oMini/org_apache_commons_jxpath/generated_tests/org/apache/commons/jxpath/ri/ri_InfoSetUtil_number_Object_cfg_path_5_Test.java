package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_InfoSetUtil_number_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testNumberWithString() {
        String input = "123.45";
        Number result = InfoSetUtil.number(input);
        assertEquals(Double.valueOf(123.45), result);
    }

    @Test(timeout = 4000)
    public void testNumberWithBooleanTrue() {
        Boolean input = true;
        Number result = InfoSetUtil.number(input);
        assertEquals(1, result); // Changed to use the numeric value directly
    }

    @Test(timeout = 4000)
    public void testNumberWithBooleanFalse() {
        Boolean input = false;
        Number result = InfoSetUtil.number(input);
        assertEquals(0, result); // Changed to use the numeric value directly
    }

    @Test(timeout = 4000)
    public void testNumberWithInvalidString() {
        String input = "invalid";
        Number result = InfoSetUtil.number(input);
        assertEquals(Double.NaN, result); // Changed to use Double.NaN for invalid number
    }

    @Test(timeout = 4000)
    public void testNumberWithNull() {
        Object input = null;
        Number result = InfoSetUtil.number(input);
        assertEquals(Double.NaN, result); // Changed to use Double.NaN for null input
    }


}