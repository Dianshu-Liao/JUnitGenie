package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.Pointer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_InfoSetUtil_number_Object_cfg_path_10_Test {


    @Test(timeout = 4000)
    public void testNumberWithString() {
        String validNumberString = "123.45";
        try {
            Number result = InfoSetUtil.number(validNumberString);
            assertEquals(123.45, result);
        } catch (Exception ex) {
            // Handle the exception if it occurs
            ex.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testNumberWithBooleanTrue() {
        Boolean booleanValue = true;
        try {
            Number result = InfoSetUtil.number(booleanValue);
            assertEquals(1, result);
        } catch (Exception ex) {
            // Handle the exception if it occurs
            ex.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testNumberWithBooleanFalse() {
        Boolean booleanValue = false;
        try {
            Number result = InfoSetUtil.number(booleanValue);
            assertEquals(0, result);
        } catch (Exception ex) {
            // Handle the exception if it occurs
            ex.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testNumberWithInvalidString() {
        String invalidNumberString = "not a number";
        try {
            Number result = InfoSetUtil.number(invalidNumberString);
            // Assuming NOT_A_NUMBER is a constant that can be accessed
            assertEquals(Double.NaN, result); // Use Double.NaN for invalid number
        } catch (Exception ex) {
            // Handle the exception if it occurs
            ex.printStackTrace();
        }
    }


}
