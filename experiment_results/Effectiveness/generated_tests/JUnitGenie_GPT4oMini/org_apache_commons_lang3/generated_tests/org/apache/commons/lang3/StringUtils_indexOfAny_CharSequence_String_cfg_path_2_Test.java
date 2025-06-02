package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_indexOfAny_CharSequence_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIndexOfAny_withNonEmptyParameters() {
        // Given
        CharSequence cs = "example";
        String searchChars = "aeiou";

        // When
        int result = StringUtils.indexOfAny(cs, searchChars);

        // Then
        // In this case, the return value should be the index of 'e' which is 1
        assertEquals(1, result);
    }

    @Test(timeout = 4000)
    public void testIndexOfAny_withEmptyCharSequence() {
        // Given
        CharSequence cs = "";
        String searchChars = "aeiou";

        // When
        try {
            int result = StringUtils.indexOfAny(cs, searchChars);
            // Then
            assertEquals(-1, result);
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIndexOfAny_withEmptySearchChars() {
        // Given
        CharSequence cs = "example";
        String searchChars = "";

        // When
        try {
            int result = StringUtils.indexOfAny(cs, searchChars);
            // Then
            assertEquals(-1, result);
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIndexOfAny_withNullCharSequence() {
        // Given
        CharSequence cs = null;
        String searchChars = "aeiou";

        // When
        try {
            int result = StringUtils.indexOfAny(cs, searchChars);
            // Then
            assertEquals(-1, result);
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }

}