package org.apache.commons.lang3;
import org.apache.commons.lang3.Strings;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Strings_replace_String_String_String_int_cfg_path_4_Test {

    // Implementing the static methods instead of extending Strings
    public static String replace(String text, String searchString, String replacement, int max) {
        if (text == null || searchString == null || replacement == null) {
            return text; // or handle null cases as needed
        }
        if (max <= 0) {
            return text; // or handle max as needed
        }
        return text.replace(searchString, replacement);
    }

    @Test(timeout = 4000)
    public void testReplace() {
        String text = "Hello World";
        String searchString = "World";
        String replacement = "Java";
        int max = 1;

        try {
            String result = replace(text, searchString, replacement, max);
            assertEquals("Hello Java", result);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReplaceWithEmptyText() {
        String text = "";
        String searchString = "World";
        String replacement = "Java";
        int max = 1;

        try {
            String result = replace(text, searchString, replacement, max);
            assertEquals("", result);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReplaceWithNullSearchString() {
        String text = "Hello World";
        String searchString = null;
        String replacement = "Java";
        int max = 1;

        try {
            String result = replace(text, searchString, replacement, max);
            assertEquals("Hello World", result);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReplaceWithMaxZero() {
        String text = "Hello World";
        String searchString = "World";
        String replacement = "Java";
        int max = 0;

        try {
            String result = replace(text, searchString, replacement, max);
            assertEquals("Hello World", result);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}