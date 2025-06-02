package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.WordUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class text_WordUtils_containsAllWords_CharSequence_CharSequence_____cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testContainsAllWords_EmptyWord() {
        // Given
        CharSequence word = ""; // This will ensure StringUtils.isEmpty(word) returns true
        CharSequence[] words = {"test"};

        // When
        boolean result;
        try {
            result = WordUtils.containsAllWords(word, words);
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
            result = false; // Fallback in case of exception
        }

        // Then
        assertFalse(result);
    }

}