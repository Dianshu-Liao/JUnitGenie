package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_isMixedCase_CharSequence_cfg_path_22_Test {

    @Test(timeout = 4000)
    public void testIsMixedCaseWithNullInput() {
        try {
            CharSequence input = null; // This meets the constraint for isEmpty
            boolean result = StringUtils.isMixedCase(input);
            assertFalse(result); // Expecting false since input is null
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}