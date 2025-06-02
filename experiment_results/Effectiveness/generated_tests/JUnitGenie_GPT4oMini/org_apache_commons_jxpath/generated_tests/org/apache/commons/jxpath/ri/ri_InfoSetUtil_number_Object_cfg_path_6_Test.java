package org.apache.commons.jxpath.ri;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_InfoSetUtil_number_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testNumberWithStringThatCannotBeParsed() {
        Object input = "invalidNumber";
        Number result;

        try {
            result = InfoSetUtil.number(input);
            assertEquals(Double.valueOf(Double.NaN), result);
        } catch (Exception ex) {
            // Handle the exception if necessary
        }
    }

}