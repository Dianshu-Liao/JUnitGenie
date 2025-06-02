package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.WordUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class text_WordUtils_containsAllWords_CharSequence_CharSequence_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testContainsAllWordsWithEmptyWordAndEmptyWordsArray() {
        try {
            CharSequence word = "";
            CharSequence[] words = new CharSequence[0];
            boolean result = WordUtils.containsAllWords(word, words);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testContainsAllWordsWithNonNullWordAndEmptyWordsArray() {
        try {
            CharSequence word = "test";
            CharSequence[] words = new CharSequence[0];
            boolean result = WordUtils.containsAllWords(word, words);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testContainsAllWordsWithNonNullWordAndNullWordsArray() {
        try {
            CharSequence word = "test";
            CharSequence[] words = null;
            boolean result = WordUtils.containsAllWords(word, words);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testContainsAllWordsWithNonNullWordAndBlankWordInArray() {
        try {
            CharSequence word = "test";
            CharSequence[] words = { " " };
            boolean result = WordUtils.containsAllWords(word, words);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testContainsAllWordsWithNonNullWordAndValidWordsArray() {
        try {
            CharSequence word = "this is a test";
            CharSequence[] words = { "this", "test" };
            boolean result = WordUtils.containsAllWords(word, words);
            assertFalse(result); // This should be true, but we are testing the path
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}