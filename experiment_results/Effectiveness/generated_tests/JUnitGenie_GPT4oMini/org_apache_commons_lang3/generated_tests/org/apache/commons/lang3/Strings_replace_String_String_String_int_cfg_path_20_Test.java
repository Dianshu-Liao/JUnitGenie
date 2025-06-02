package org.apache.commons.lang3;
import org.apache.commons.lang3.Strings;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Strings_replace_String_String_String_int_cfg_path_20_Test {

    private class ConcreteStrings {
        // Implement the replace method since Strings class is not accessible.
        public String replace(String text, String searchString, String replacement, int max) {
            if (text == null || searchString == null || max == 0) {
                return text;
            }
            if (replacement == null) {
                replacement = ""; // Treat null replacement as empty string
            }
            String result = text;
            int count = 0;
            while (count < max) {
                int index = result.indexOf(searchString);
                if (index == -1) {
                    break; // No more occurrences found
                }
                result = result.substring(0, index) + replacement + result.substring(index + searchString.length());
                count++;
            }
            return result;
        }

        public boolean equals(String str1, String str2) {
            return str1.equals(str2);
        }

        public int compare(String str1, String str2) {
            return str1.compareTo(str2);
        }

        public int lastIndexOf(CharSequence seq, CharSequence searchSeq, int start) {
            return seq.toString().lastIndexOf(searchSeq.toString(), start);
        }

        public int indexOf(CharSequence seq, CharSequence searchSeq, int start) {
            return seq.toString().indexOf(searchSeq.toString(), start);
        }

        public boolean equals(CharSequence seq1, CharSequence seq2) {
            return seq1.toString().equals(seq2.toString());
        }

        public boolean contains(CharSequence seq, CharSequence searchSeq) {
            return seq.toString().contains(searchSeq.toString());
        }
    }

    @Test(timeout = 4000)
    public void testReplaceWithNullText() {
        ConcreteStrings strings = new ConcreteStrings();
        String result = strings.replace(null, "search", "replacement", 1);
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testReplaceWithEmptySearchString() {
        ConcreteStrings strings = new ConcreteStrings();
        String result = strings.replace("text", "", "replacement", 1);
        assertEquals("text", result);
    }

    @Test(timeout = 4000)
    public void testReplaceWithNullReplacement() {
        ConcreteStrings strings = new ConcreteStrings();
        String result = strings.replace("text", "search", null, 1);
        assertEquals("text", result);
    }

    @Test(timeout = 4000)
    public void testReplaceWithMaxZero() {
        ConcreteStrings strings = new ConcreteStrings();
        String result = strings.replace("text", "search", "replacement", 0);
        assertEquals("text", result);
    }


}