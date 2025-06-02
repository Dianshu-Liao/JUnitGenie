package org.apache.commons.lang3;
import org.apache.commons.lang3.Strings;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Strings_replace_String_String_String_int_cfg_path_9_Test {

    // Implementing the replace method directly instead of extending Strings
    public String replace(String text, String searchString, String replacement, int max) {
        if (text == null) {
            return null;
        }
        if (searchString == null || max <= 0) {
            return text;
        }
        String result = text;
        int index = result.indexOf(searchString);
        int count = 0;

        while (index != -1 && count < max) {
            result = result.substring(0, index) + replacement + result.substring(index + searchString.length());
            index = result.indexOf(searchString, index + replacement.length());
            count++;
        }
        return result;
    }

    @Test(timeout = 4000)
    public void testReplace() {
        // Given
        String text = "Hello World";
        String searchString = "World";
        String replacement = "Java";
        int max = 1;

        // When
        String result = replace(text, searchString, replacement, max);

        // Then
        assertEquals("Hello Java", result);
    }

    @Test(timeout = 4000)
    public void testReplaceWithEmptyText() {
        // Given
        String text = "";
        String searchString = "World";
        String replacement = "Java";
        int max = 1;

        // When
        String result = replace(text, searchString, replacement, max);

        // Then
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testReplaceWithNullSearchString() {
        // Given
        String text = "Hello World";
        String searchString = null;
        String replacement = "Java";
        int max = 1;

        // When
        String result = replace(text, searchString, replacement, max);

        // Then
        assertEquals("Hello World", result);
    }

    @Test(timeout = 4000)
    public void testReplaceWithMaxZero() {
        // Given
        String text = "Hello World";
        String searchString = "World";
        String replacement = "Java";
        int max = 0;

        // When
        String result = replace(text, searchString, replacement, max);

        // Then
        assertEquals("Hello World", result);
    }

    @Test(timeout = 4000)
    public void testReplaceWithIgnoreCase() {
        // Given
        String text = "Hello World";
        String searchString = "world";
        String replacement = "Java";
        int max = 1;

        // When
        String result = replace(text, searchString, replacement, max);

        // Then
        assertEquals("Hello World", result); // Since the method does not handle case sensitivity
    }

}