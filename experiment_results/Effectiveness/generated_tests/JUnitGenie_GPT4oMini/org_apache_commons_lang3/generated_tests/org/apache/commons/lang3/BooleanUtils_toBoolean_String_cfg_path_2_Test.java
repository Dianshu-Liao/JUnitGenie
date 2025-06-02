package org.apache.commons.lang3;
import org.apache.commons.lang3.BooleanUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class BooleanUtils_toBoolean_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToBoolean_NonTrueString() {
        String input = "false"; // This input is non-null, not "true", and has a length greater than 0
        try {
            boolean result = BooleanUtils.toBoolean(input);
            assertFalse(result); // Expecting false since input is not "true"
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testToBoolean_EmptyString() {
        String input = ""; // This input is non-null but has a length of 0
        try {
            boolean result = BooleanUtils.toBoolean(input);
            assertFalse(result); // Expecting false since input is not "true"
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testToBoolean_NullString() {
        String input = null; // This input is null
        try {
            boolean result = BooleanUtils.toBoolean(input);
            assertFalse(result); // Expecting false since input is not "true"
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}