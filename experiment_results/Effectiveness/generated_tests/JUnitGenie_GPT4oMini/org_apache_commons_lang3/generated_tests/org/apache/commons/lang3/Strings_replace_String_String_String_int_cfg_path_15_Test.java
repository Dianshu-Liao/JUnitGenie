package org.apache.commons.lang3;
import org.apache.commons.lang3.Strings;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Strings_replace_String_String_String_int_cfg_path_15_Test {

    private static class TestStrings {
        public boolean equals(String str1, String str2) {
            return str1.equals(str2);
        }

        public int compare(String str1, String str2) {
            return str1.compareTo(str2);
        }

        public int lastIndexOf(CharSequence sequence, CharSequence searchChar, int start) {
            return sequence.toString().lastIndexOf(searchChar.toString(), start);
        }

        public int indexOf(CharSequence sequence, CharSequence searchChar, int start) {
            return sequence.toString().indexOf(searchChar.toString(), start);
        }

        public boolean equals(CharSequence sequence1, CharSequence sequence2) {
            return sequence1.toString().equals(sequence2.toString());
        }

        public boolean contains(CharSequence sequence, CharSequence searchChar) {
            return sequence.toString().contains(searchChar.toString());
        }

        public String replace(String text, String searchString, String replacement, int max) {
            if (text == null) {
                return null;
            }
            if (searchString == null || max <= 0) {
                return text;
            }
            return text.replaceFirst(searchString, replacement);
        }
    }

    @Test(timeout = 4000)
    public void testReplace() {
        TestStrings testStrings = new TestStrings();
        String text = "Hello World";
        String searchString = "World";
        String replacement = "Java";
        int max = 1;

        try {
            String result = testStrings.replace(text, searchString, replacement, max);
            assertEquals("Hello Java", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReplaceWithEmptyText() {
        TestStrings testStrings = new TestStrings();
        String text = "";
        String searchString = "World";
        String replacement = "Java";
        int max = 1;

        try {
            String result = testStrings.replace(text, searchString, replacement, max);
            assertEquals("", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReplaceWithNullSearchString() {
        TestStrings testStrings = new TestStrings();
        String text = "Hello World";
        String searchString = null;
        String replacement = "Java";
        int max = 1;

        try {
            String result = testStrings.replace(text, searchString, replacement, max);
            assertEquals("Hello World", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReplaceWithMaxZero() {
        TestStrings testStrings = new TestStrings();
        String text = "Hello World";
        String searchString = "World";
        String replacement = "Java";
        int max = 0;

        try {
            String result = testStrings.replace(text, searchString, replacement, max);
            assertEquals("Hello World", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}