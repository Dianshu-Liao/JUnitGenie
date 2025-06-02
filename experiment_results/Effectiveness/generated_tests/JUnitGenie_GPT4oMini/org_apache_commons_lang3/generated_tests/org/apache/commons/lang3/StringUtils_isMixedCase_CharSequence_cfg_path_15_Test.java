package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_isMixedCase_CharSequence_cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testIsMixedCaseWithNullInput() {
        // Given
        CharSequence input = null;

        // When
        boolean result = StringUtils.isMixedCase(input);

        // Then
        assertFalse(result);
    }

}