package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_substringAfter_String_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testSubstringAfterWithEmptyString() {
        String str = ""; // parameter0
        String separator = "separator"; // parameter1
        try {
            String result = StringUtils.substringAfter(str, separator);
            assertEquals("", result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testSubstringAfterWithNullSeparator() {
        String str = "test"; // parameter0
        String separator = null; // parameter1
        try {
            String result = StringUtils.substringAfter(str, separator);
            assertEquals("", result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}