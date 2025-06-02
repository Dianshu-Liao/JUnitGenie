package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrMatcher;
import org.apache.commons.lang3.text.StrTokenizer;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class text_StrTokenizer__init__String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testStrTokenizerWithValidInput() {
        // Given
        String input = "Hello, World!";
        
        // When
        StrTokenizer tokenizer = new StrTokenizer(input);

        // Then
        // Use the toCharArray method to get the characters from the string
        assertArrayEquals(new String[] {"H", "e", "l", "l", "o", ",", " ", "W", "o", "r", "l", "d", "!"}, tokenizer.getTokenArray());
    }

    @Test(timeout = 4000)
    public void testStrTokenizerWithNullInput() {
        // Given
        String input = null;
        
        // When
        StrTokenizer tokenizer = new StrTokenizer(input);

        // Then
        // Check if the tokenizer returns an empty array for null input
        assertArrayEquals(new String[0], tokenizer.getTokenArray());
    }


}