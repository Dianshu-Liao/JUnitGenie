package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSetUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharSetUtils_squeeze_String_String_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testSqueezeWithNullStringAndEmptySet() {
        // Given
        String str = null;
        String[] set = new String[] { "" }; // Empty string in the set

        // When
        String result = CharSetUtils.squeeze(str, set);

        // Then
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithEmptyStringAndNonEmptySet() {
        // Given
        String str = "";
        String[] set = new String[] { "a", "b" }; // Non-empty set

        // When
        String result = CharSetUtils.squeeze(str, set);

        // Then
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithRepeatedCharacters() {
        // Given
        String str = "aaabbbccc";
        String[] set = new String[] { "a", "b" }; // Set containing 'a' and 'b'

        // When
        String result = CharSetUtils.squeeze(str, set);

        // Then
        assertEquals("abc", result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithEmptySet() {
        // Given
        String str = "aaabbbccc";
        String[] set = new String[] {}; // Empty set

        // When
        String result = CharSetUtils.squeeze(str, set);

        // Then
        assertEquals("abc", result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithNullSet() {
        // Given
        String str = "aaabbbccc";
        String[] set = null; // Null set

        // When
        String result = CharSetUtils.squeeze(str, set);

        // Then
        assertEquals("abc", result);
    }

}