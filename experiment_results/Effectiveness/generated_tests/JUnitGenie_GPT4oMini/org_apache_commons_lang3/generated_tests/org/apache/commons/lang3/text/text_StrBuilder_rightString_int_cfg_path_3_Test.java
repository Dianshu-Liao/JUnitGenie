package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_rightString_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testRightStringWithNonPositiveLength() {
        StrBuilder strBuilder = new StrBuilder();
        String result = strBuilder.rightString(0);
        assertEquals("", result);
    }
    
    @Test(timeout = 4000)
    public void testRightStringWithNegativeLength() {
        StrBuilder strBuilder = new StrBuilder();
        String result = strBuilder.rightString(-1);
        assertEquals("", result);
    }

}