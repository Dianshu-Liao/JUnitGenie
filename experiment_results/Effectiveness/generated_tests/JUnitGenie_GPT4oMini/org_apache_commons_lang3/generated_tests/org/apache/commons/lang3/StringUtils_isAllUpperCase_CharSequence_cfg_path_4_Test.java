package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class StringUtils_isAllUpperCase_CharSequence_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testIsAllUpperCase() {
        // Test case where CharSequence is all uppercase
        CharSequence input = "ALLUPPERCASE";
        try {
            boolean result = StringUtils.isAllUpperCase(input);
            assertTrue(result);
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsAllUpperCaseWithEmptyString() {
        // Test case where CharSequence is an empty string
        CharSequence input = "";
        try {
            boolean result = StringUtils.isAllUpperCase(input);
            assertTrue(!result);
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsAllUpperCaseWithMixedCase() {
        // Test case where CharSequence has mixed case
        CharSequence input = "MixedCase";
        try {
            boolean result = StringUtils.isAllUpperCase(input);
            assertTrue(!result);
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsAllUpperCaseWithLowerCase() {
        // Test case where CharSequence is all lowercase
        CharSequence input = "alllowercase";
        try {
            boolean result = StringUtils.isAllUpperCase(input);
            assertTrue(!result);
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsAllUpperCaseWithNull() {
        // Test case where CharSequence is null
        CharSequence input = null;
        try {
            boolean result = StringUtils.isAllUpperCase(input);
            assertTrue(!result);
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

}