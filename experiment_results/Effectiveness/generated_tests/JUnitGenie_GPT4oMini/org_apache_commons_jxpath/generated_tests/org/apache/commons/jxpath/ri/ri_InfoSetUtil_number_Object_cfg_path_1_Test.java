package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_InfoSetUtil_number_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testNumberWithNumberObject() {
        Object input = 42; // A Number object
        Number result = InfoSetUtil.number(input);
        assertEquals(42, result);
    }

    @Test(timeout = 4000)
    public void testNumberWithBooleanTrue() {
        Object input = Boolean.TRUE; // A Boolean object
        Number result = InfoSetUtil.number(input);
        assertEquals(1, result); // Changed to use 1 instead of InfoSetUtil.ONE
    }

    @Test(timeout = 4000)
    public void testNumberWithBooleanFalse() {
        Object input = Boolean.FALSE; // A Boolean object
        Number result = InfoSetUtil.number(input);
        assertEquals(0, result); // Changed to use 0 instead of InfoSetUtil.ZERO
    }

    @Test(timeout = 4000)
    public void testNumberWithString() {
        Object input = "123.45"; // A String that can be converted to a Number
        Number result = InfoSetUtil.number(input);
        assertEquals(Double.valueOf(123.45), result);
    }

    @Test(timeout = 4000)
    public void testNumberWithInvalidString() {
        Object input = "not a number"; // A String that cannot be converted to a Number
        Number result = InfoSetUtil.number(input);
        assertEquals(Double.NaN, result); // Changed to use Double.NaN instead of InfoSetUtil.NOT_A_NUMBER
    }

    @Test(timeout = 4000)
    public void testNumberWithNull() {
        Object input = null; // A null object
        Number result = InfoSetUtil.number(input);
        assertEquals(Double.NaN, result); // Changed to use Double.NaN instead of InfoSetUtil.NOT_A_NUMBER
    }


}