package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_isAllUpperCase_CharSequence_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsAllUpperCaseWithEmptyString() {
        // Given
        CharSequence input = ""; // This input is not null and is empty

        // When
        boolean result = StringUtils.isAllUpperCase(input);

        // Then
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsAllUpperCaseWithNull() {
        // Given
        CharSequence input = null; // This input is null

        // When
        try {
            boolean result = StringUtils.isAllUpperCase(input);
        } catch (NullPointerException e) {
            // Then
            // Expected exception for null input
        }
    }

}