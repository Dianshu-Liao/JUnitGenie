package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_substringAfterLast_String_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testSubstringAfterLastWithEmptyStringAndSeparator() {
        String str = ""; // parameter0
        String separator = ""; // parameter1
        String result;

        try {
            result = StringUtils.substringAfterLast(str, separator);
            assertEquals("", result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testSubstringAfterLastWithValidStringAndEmptySeparator() {
        String str = "example"; // parameter0
        String separator = ""; // parameter1
        String result;

        try {
            result = StringUtils.substringAfterLast(str, separator);
            assertEquals("", result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testSubstringAfterLastWithNoSeparatorFound() {
        String str = "example"; // parameter0
        String separator = "notfound"; // parameter1
        String result;

        try {
            result = StringUtils.substringAfterLast(str, separator);
            assertEquals("", result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testSubstringAfterLastWithSeparatorAtEnd() {
        String str = "example"; // parameter0
        String separator = "example"; // parameter1
        String result;

        try {
            result = StringUtils.substringAfterLast(str, separator);
            assertEquals("", result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testSubstringAfterLastWithValidStringAndSeparator() {
        String str = "example/test"; // parameter0
        String separator = "/"; // parameter1
        String result;

        try {
            result = StringUtils.substringAfterLast(str, separator);
            assertEquals("test", result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}