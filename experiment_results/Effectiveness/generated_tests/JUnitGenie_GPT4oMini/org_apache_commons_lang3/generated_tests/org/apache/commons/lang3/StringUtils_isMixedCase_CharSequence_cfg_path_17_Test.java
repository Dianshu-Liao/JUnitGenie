package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtils_isMixedCase_CharSequence_cfg_path_17_Test {

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
            fail("Exception should not be thrown for null input");
        }
    }

}