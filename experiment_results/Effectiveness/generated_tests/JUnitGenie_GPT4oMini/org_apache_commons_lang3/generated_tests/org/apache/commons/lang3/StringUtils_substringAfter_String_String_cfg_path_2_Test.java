package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_substringAfter_String_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSubstringAfterWithEmptyString() {
        String str = ""; // parameter0: empty string meets the isEmpty condition
        String separator = "separator"; // parameter1 can be any string
        try {
            // This test case should return an empty string since str is empty
            String result = StringUtils.substringAfter(str, separator);
            assertEquals("", result);
        } catch (Exception e) {
            // Exception handling for unexpected errors
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSubstringAfterWithNonNullSeparator() {
        String str = "hello world"; // parameter0: non-null string
        String separator = " "; // parameter1: non-null separator
        try {
            // This test case should return "world" since the separator is present
            String result = StringUtils.substringAfter(str, separator);
            assertEquals("world", result);
        } catch (Exception e) {
            // Exception handling for unexpected errors
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSubstringAfterWithMissingSeparator() {
        String str = "hello world"; // parameter0: non-null string
        String separator = ","; // parameter1: non-null separator that doesn't exist in the string
        try {
            // This test case should return an empty string since the separator is not found
            String result = StringUtils.substringAfter(str, separator);
            assertEquals("", result);
        } catch (Exception e) {
            // Exception handling for unexpected errors
            e.printStackTrace();
        }
    }

}