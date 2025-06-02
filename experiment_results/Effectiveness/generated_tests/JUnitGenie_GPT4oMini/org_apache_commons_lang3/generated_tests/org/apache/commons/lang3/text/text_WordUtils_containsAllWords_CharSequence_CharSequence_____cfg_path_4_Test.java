package org.apache.commons.lang3.text;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class text_WordUtils_containsAllWords_CharSequence_CharSequence_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testContainsAllWordsWithNullWordAndEmptyWords() {
        try {
            CharSequence word = null;
            CharSequence[] words = new CharSequence[0];
            boolean result = WordUtils.containsAllWords(word, words);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testContainsAllWordsWithNonNullWordAndEmptyWords() {
        try {
            CharSequence word = "Hello World";
            CharSequence[] words = new CharSequence[0];
            boolean result = WordUtils.containsAllWords(word, words);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testContainsAllWordsWithNonNullWordAndBlankWord() {
        try {
            CharSequence word = "Hello World";
            CharSequence[] words = new CharSequence[]{" "}; // Blank word
            boolean result = WordUtils.containsAllWords(word, words);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}