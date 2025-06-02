package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtils_isMixedCase_CharSequence_cfg_path_21_Test {

    @Test(timeout = 4000)
    public void testIsMixedCaseWithNull() {
        try {
            // Given
            CharSequence cs = null;

            // When
            boolean result = StringUtils.isMixedCase(cs);

            // Then
            assertFalse(result);
        } catch (Exception e) {
            fail("Exception should not be thrown for null input");
        }
    }

}