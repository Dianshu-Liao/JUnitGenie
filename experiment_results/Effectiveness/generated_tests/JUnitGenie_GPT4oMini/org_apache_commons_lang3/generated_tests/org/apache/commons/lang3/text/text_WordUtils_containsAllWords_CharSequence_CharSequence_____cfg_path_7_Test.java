package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.WordUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class text_WordUtils_containsAllWords_CharSequence_CharSequence_____cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testContainsAllWords_withNullWordAndEmptyArray() {
        // Given
        CharSequence word = null;
        CharSequence[] words = new CharSequence[0]; // Empty array

        // When
        try {
            boolean result = WordUtils.containsAllWords(word, words);

            // Then
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception since we expect the method to handle null input.
            e.printStackTrace();
        }
    }

}