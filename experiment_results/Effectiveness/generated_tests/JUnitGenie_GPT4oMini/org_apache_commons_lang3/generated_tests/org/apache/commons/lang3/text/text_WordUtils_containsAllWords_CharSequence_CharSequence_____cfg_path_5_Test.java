package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.WordUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class text_WordUtils_containsAllWords_CharSequence_CharSequence_____cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testContainsAllWordsWithEmptyWordAndEmptyWords() {
        // Test case where word is not empty and words is an empty array
        CharSequence word = "Hello World";
        CharSequence[] words = new CharSequence[0]; // empty array
        boolean result = WordUtils.containsAllWords(word, words);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAllWordsWithNullWord() {
        // Test case where word is null
        CharSequence word = null;
        CharSequence[] words = {"Hello", "World"};
        boolean result = WordUtils.containsAllWords(word, words);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAllWordsWithBlankWord() {
        // Test case where word is blank
        CharSequence word = "   ";
        CharSequence[] words = {"Hello", "World"};
        boolean result = WordUtils.containsAllWords(word, words);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAllWordsWithNullWords() {
        // Test case where words is null
        CharSequence word = "Hello World";
        CharSequence[] words = null;
        boolean result = WordUtils.containsAllWords(word, words);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAllWordsWithBlankWords() {
        // Test case where words contain blank CharSequence
        CharSequence word = "Hello World";
        CharSequence[] words = {"Hello", "   "}; // contains a blank
        boolean result = WordUtils.containsAllWords(word, words);
        assertFalse(result);
    }

}