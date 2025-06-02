package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_leftString_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testLeftStringWithNonPositiveLength() {
        StrBuilder strBuilder = new StrBuilder();
        String result = strBuilder.leftString(0);
        assertEquals("", result);
    }

}