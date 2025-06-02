package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class text_StrBuilder_endsWith_String_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testEndsWith_NullString() {
        StrBuilder strBuilder = new StrBuilder();
        try {
            boolean result = strBuilder.endsWith(null);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

}