package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.WordUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class text_WordUtils_containsAllWords_CharSequence_CharSequence_____cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testContainsAllWordsWithEmptyWordAndEmptyWordsArray() {
        // Test case where word is empty and words array is empty
        CharSequence word = "";
        CharSequence[] words = new CharSequence[0];
        try {
            boolean result = WordUtils.containsAllWords(word, words);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testContainsAllWordsWithNullWordAndEmptyWordsArray() {
        // Test case where word is null and words array is empty
        CharSequence word = null;
        CharSequence[] words = new CharSequence[0];
        try {
            boolean result = WordUtils.containsAllWords(word, words);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testContainsAllWordsWithNonEmptyWordAndNullWordsArray() {
        // Test case where word is non-empty and words array is null
        CharSequence word = "hello world";
        CharSequence[] words = null;
        try {
            boolean result = WordUtils.containsAllWords(word, words);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testContainsAllWordsWithNonEmptyWordAndEmptyWordsArray() {
        // Test case where word is non-empty and words array is empty
        CharSequence word = "hello world";
        CharSequence[] words = new CharSequence[0];
        try {
            boolean result = WordUtils.containsAllWords(word, words);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testContainsAllWordsWithNonBlankWordAndBlankWordInArray() {
        // Test case where word is non-empty and contains a blank word in the array
        CharSequence word = "hello world";
        CharSequence[] words = {" "}; // Blank word
        try {
            boolean result = WordUtils.containsAllWords(word, words);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}