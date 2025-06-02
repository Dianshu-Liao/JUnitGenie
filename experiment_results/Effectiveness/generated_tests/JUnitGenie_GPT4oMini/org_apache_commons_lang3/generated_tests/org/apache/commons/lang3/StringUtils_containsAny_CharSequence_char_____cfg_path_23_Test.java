package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class StringUtils_containsAny_CharSequence_char_____cfg_path_23_Test {

    @Test(timeout = 4000)
    public void testContainsAnyWithNullCsAndNullSearchChars() {
        try {
            // Given
            CharSequence cs = null;
            char[] searchChars = null;
            
            // When
            boolean result = StringUtils.containsAny(cs, searchChars);
            
            // Then
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception as part of testing the throw scenario.
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testContainsAnyWithNullCsAndEmptySearchChars() {
        try {
            // Given
            CharSequence cs = null;
            char[] searchChars = new char[0]; // empty array
            
            // When
            boolean result = StringUtils.containsAny(cs, searchChars);
            
            // Then
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception as part of testing the throw scenario.
            e.printStackTrace();
        }
    }

}