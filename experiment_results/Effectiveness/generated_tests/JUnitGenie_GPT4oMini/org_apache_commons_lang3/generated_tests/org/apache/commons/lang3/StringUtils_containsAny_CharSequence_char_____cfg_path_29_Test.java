package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtils_containsAny_CharSequence_char_____cfg_path_29_Test {

    @Test(timeout = 4000)
    public void testContainsAny_WithNullCsAndNullSearchChars() {
        // Arrange
        CharSequence cs = null;
        char[] searchChars = null;

        // Act
        boolean result = StringUtils.containsAny(cs, searchChars);

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAny_WithNullCsAndEmptySearchChars() {
        // Arrange
        CharSequence cs = null;
        char[] searchChars = new char[0];

        // Act
        boolean result = StringUtils.containsAny(cs, searchChars);

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAny_WithEmptyCsAndNullSearchChars() {
        // Arrange
        CharSequence cs = "";
        char[] searchChars = null;

        // Act
        boolean result = StringUtils.containsAny(cs, searchChars);

        // Assert
        assertFalse(result);
    }
    
    @Test(timeout = 4000)
    public void testContainsAny_WithEmptyCsAndEmptySearchChars() {
        // Arrange
        CharSequence cs = "";
        char[] searchChars = new char[0];

        // Act
        boolean result = StringUtils.containsAny(cs, searchChars);

        // Assert
        assertFalse(result);
    }

}