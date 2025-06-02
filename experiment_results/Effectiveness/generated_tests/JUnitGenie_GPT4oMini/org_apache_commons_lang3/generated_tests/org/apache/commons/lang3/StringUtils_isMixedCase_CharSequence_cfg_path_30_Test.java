package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_isMixedCase_CharSequence_cfg_path_30_Test {

    @Test(timeout = 4000)
    public void testIsMixedCaseWithEmptyString() {
        // Given
        CharSequence cs = ""; // Empty string

        // When
        boolean result = StringUtils.isMixedCase(cs);

        // Then
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsMixedCaseWithSingleCharacter() {
        // Given
        CharSequence cs = "A"; // Single uppercase character

        // When
        boolean result = StringUtils.isMixedCase(cs);

        // Then
        assertFalse(result);
    }

}