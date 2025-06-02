package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.WordUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class text_WordUtils_containsAllWords_CharSequence_CharSequence_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testContainsAllWordsWithNonEmptyWordAndEmptyWordsArray() {
        CharSequence word = "This is a test";
        CharSequence[] words = {}; // Empty array

        try {
            boolean result = WordUtils.containsAllWords(word, words);
            assertFalse(result); // Expecting false since words array is empty
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testContainsAllWordsWithNonEmptyWordAndBlankWordInArray() {
        CharSequence word = "This is a test";
        CharSequence[] words = { " " }; // Blank word

        try {
            boolean result = WordUtils.containsAllWords(word, words);
            assertFalse(result); // Expecting false since the word in array is blank
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

}