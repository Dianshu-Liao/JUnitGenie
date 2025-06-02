package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.WordUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class text_WordUtils_containsAllWords_CharSequence_CharSequence_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testContainsAllWordsWithNonEmptyWordAndNonEmptyWords() {
        CharSequence word = "The quick brown fox";
        CharSequence[] words = {"quick", "fox"};
        boolean result = WordUtils.containsAllWords(word, words);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testContainsAllWordsWithEmptyWord() {
        CharSequence word = "";
        CharSequence[] words = {"quick", "fox"};
        boolean result = WordUtils.containsAllWords(word, words);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAllWordsWithNullWord() {
        CharSequence word = null;
        CharSequence[] words = {"quick", "fox"};
        boolean result = WordUtils.containsAllWords(word, words);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAllWordsWithEmptyWordsArray() {
        CharSequence word = "The quick brown fox";
        CharSequence[] words = {};
        boolean result = WordUtils.containsAllWords(word, words);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAllWordsWithNullWordsArray() {
        CharSequence word = "The quick brown fox";
        CharSequence[] words = null;
        boolean result = WordUtils.containsAllWords(word, words);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAllWordsWithBlankWordInArray() {
        CharSequence word = "The quick brown fox";
        CharSequence[] words = {"quick", " "};
        boolean result = WordUtils.containsAllWords(word, words);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAllWordsWithWordNotInSentence() {
        CharSequence word = "The quick brown fox";
        CharSequence[] words = {"quick", "cat"};
        boolean result = WordUtils.containsAllWords(word, words);
        assertFalse(result);
    }

}