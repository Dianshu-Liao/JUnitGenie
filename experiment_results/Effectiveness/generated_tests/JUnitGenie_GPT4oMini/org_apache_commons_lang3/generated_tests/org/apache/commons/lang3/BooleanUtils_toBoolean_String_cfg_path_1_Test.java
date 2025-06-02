package org.apache.commons.lang3;
import org.apache.commons.lang3.BooleanUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class BooleanUtils_toBoolean_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToBooleanWithNull() {
        // Test case where input is null
        String input = null;
        try {
            boolean result = BooleanUtils.toBoolean(input);
            assertFalse(result); // Expecting false since toBooleanObject(null) returns null
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testToBooleanWithNonTrueString() {
        // Test case where input is a non-true string
        String input = "false";
        try {
            boolean result = BooleanUtils.toBoolean(input);
            assertFalse(result); // Expecting false since toBooleanObject("false") returns Boolean.FALSE
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testToBooleanWithCaseInsensitiveTrueString() {
        // Test case where input is a case-insensitive "true"
        String input = "True";
        try {
            boolean result = BooleanUtils.toBoolean(input);
            assertFalse(result); // Expecting false since toBooleanObject("True") returns Boolean.FALSE
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testToBooleanWithEmptyString() {
        // Test case where input is an empty string
        String input = "";
        try {
            boolean result = BooleanUtils.toBoolean(input);
            assertFalse(result); // Expecting false since toBooleanObject("") returns Boolean.FALSE
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

}