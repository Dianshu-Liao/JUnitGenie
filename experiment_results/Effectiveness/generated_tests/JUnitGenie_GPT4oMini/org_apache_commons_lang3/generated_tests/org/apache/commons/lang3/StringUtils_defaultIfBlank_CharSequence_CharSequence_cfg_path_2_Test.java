package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_defaultIfBlank_CharSequence_CharSequence_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testDefaultIfBlank_withWhitespaceString() {
        // Given
        CharSequence str = "   "; // All characters are whitespace
        CharSequence defaultStr = "default";

        // When
        CharSequence result = StringUtils.defaultIfBlank(str, defaultStr);

        // Then
        assertEquals(defaultStr, result);
    }

    @Test(timeout = 4000)
    public void testDefaultIfBlank_withNonEmptyString() {
        // Given
        CharSequence str = "Hello"; // Non-empty string
        CharSequence defaultStr = "default";

        // When
        CharSequence result = StringUtils.defaultIfBlank(str, defaultStr);

        // Then
        assertEquals(str, result);
    }

}