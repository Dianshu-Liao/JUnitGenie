package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_isMixedCase_CharSequence_cfg_path_19_Test {

    @Test(timeout = 4000)
    public void testIsMixedCaseWithNullInput() {
        try {
            boolean result = StringUtils.isMixedCase(null);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception as needed for your context
            e.printStackTrace();
        }
    }

}