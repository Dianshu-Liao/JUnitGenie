package org.apache.commons.lang3;
import org.apache.commons.lang3.CharSetUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharSetUtils_squeeze_String_String_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSqueezeWithNullString() {
        // Given
        String str = null;
        String[] set = new String[] { "" }; // This will satisfy the deepEmpty condition

        // When
        String result = CharSetUtils.squeeze(str, set);

        // Then
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithEmptyStringAndEmptySet() {
        // Given
        String str = "";
        String[] set = new String[] { "" }; // This will satisfy the deepEmpty condition

        // When
        String result = CharSetUtils.squeeze(str, set);

        // Then
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithNonEmptyStringAndEmptySet() {
        // Given
        String str = "aaabbb";
        String[] set = new String[] { "" }; // This will satisfy the deepEmpty condition

        // When
        String result = CharSetUtils.squeeze(str, set);

        // Then
        assertEquals("ab", result);
    }

    @Test(timeout = 4000)
    public void testSqueezeWithEmptySet() {
        // Given
        String str = "aaabbb";
        String[] set = new String[] { null }; // This will not affect the squeeze operation

        // When
        String result = CharSetUtils.squeeze(str, set);

        // Then
        assertEquals("ab", result);
    }

}