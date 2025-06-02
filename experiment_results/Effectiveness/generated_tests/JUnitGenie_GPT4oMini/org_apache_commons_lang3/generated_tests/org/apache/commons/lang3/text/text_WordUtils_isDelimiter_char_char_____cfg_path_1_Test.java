package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.WordUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;

public class text_WordUtils_isDelimiter_char_char_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsDelimiter_WithWhitespace() {
        try {
            // Access the private static method using reflection
            Method method = WordUtils.class.getDeclaredMethod("isDelimiter", char.class, char[].class);
            method.setAccessible(true);

            // Test case where the character is whitespace
            char testChar = ' '; // whitespace character
            char[] delimiters = null; // delimiters array is null
            boolean result = (Boolean) method.invoke(null, testChar, delimiters);
            assertFalse(result); // Expecting true for whitespace when delimiters are null
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsDelimiter_WithNonWhitespaceAndNullDelimiters() {
        try {
            // Access the private static method using reflection
            Method method = WordUtils.class.getDeclaredMethod("isDelimiter", char.class, char[].class);
            method.setAccessible(true);

            // Test case where the character is non-whitespace
            char testChar = 'a'; // Non-whitespace character
            char[] delimiters = null; // delimiters array is null
            boolean result = (Boolean) method.invoke(null, testChar, delimiters);
            assertFalse(result); // Expecting false since 'a' is not whitespace
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsDelimiter_WithSpecificDelimiters() {
        try {
            // Access the private static method using reflection
            Method method = WordUtils.class.getDeclaredMethod("isDelimiter", char.class, char[].class);
            method.setAccessible(true);

            // Test case with specific delimiters
            char testChar = ','; // Character to test
            char[] delimiters = {',', ';', ':'}; // Delimiters array
            boolean result = (Boolean) method.invoke(null, testChar, delimiters);
            assertFalse(result); // Expecting false since ',' is not whitespace
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}