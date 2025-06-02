package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class StringUtils_substringsBetween_String_String_String_cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testSubstringsBetween_NullString() {
        try {
            String[] result = StringUtils.substringsBetween(null, "open", "close");
            assertNull(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testSubstringsBetween_EmptyOpen() {
        try {
            String[] result = StringUtils.substringsBetween("test", "", "close");
            assertNull(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testSubstringsBetween_EmptyClose() {
        try {
            String[] result = StringUtils.substringsBetween("test", "open", "");
            assertNull(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

}