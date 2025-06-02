package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class StringUtils_isAllUpperCase_CharSequence_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testIsAllUpperCase_withValidUpperCaseString() {
        CharSequence input = "HELLO";
        try {
            boolean result = StringUtils.isAllUpperCase(input);
            assertTrue(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsAllUpperCase_withEmptyString() {
        CharSequence input = "";
        try {
            boolean result = StringUtils.isAllUpperCase(input);
            assertTrue(!result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsAllUpperCase_withMixedCaseString() {
        CharSequence input = "Hello";
        try {
            boolean result = StringUtils.isAllUpperCase(input);
            assertTrue(!result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsAllUpperCase_withNullInput() {
        CharSequence input = null;
        try {
            boolean result = StringUtils.isAllUpperCase(input);
            assertTrue(!result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}