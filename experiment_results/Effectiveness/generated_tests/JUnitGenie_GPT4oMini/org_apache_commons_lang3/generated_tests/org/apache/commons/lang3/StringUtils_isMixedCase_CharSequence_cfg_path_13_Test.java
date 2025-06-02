package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_isMixedCase_CharSequence_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testIsMixedCaseWithNullInput() {
        try {
            // Given
            CharSequence input = null;

            // When
            boolean result = StringUtils.isMixedCase(input);

            // Then
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}