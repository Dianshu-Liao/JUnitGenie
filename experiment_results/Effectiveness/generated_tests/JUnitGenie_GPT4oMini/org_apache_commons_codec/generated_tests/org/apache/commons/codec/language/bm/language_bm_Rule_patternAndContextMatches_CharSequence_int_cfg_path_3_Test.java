package org.apache.commons.codec.language.bm;
import org.apache.commons.codec.language.bm.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_bm_Rule_patternAndContextMatches_CharSequence_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testPatternAndContextMatches_ValidInput_ReturnsFalse() {
        // Arrange
        String pattern = "abc";
        Rule rule = new Rule(pattern, "", "", null);
        CharSequence input = "xyz"; // input does not match the pattern
        int index = 0;

        // Act
        boolean result = rule.patternAndContextMatches(input, index);

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testPatternAndContextMatches_NegativeIndex_ThrowsException() {
        // Arrange
        String pattern = "abc";
        Rule rule = new Rule(pattern, "", "", null);
        CharSequence input = "xyz"; 
        int index = -1; // negative index

        // Act
        try {
            rule.patternAndContextMatches(input, index);
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // Assert
            assertEquals("Can not match pattern at negative indexes", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testPatternAndContextMatches_InsufficientLength_ReturnsFalse() {
        // Arrange
        String pattern = "abc";
        Rule rule = new Rule(pattern, "", "", null);
        CharSequence input = "ab"; // input length is less than pattern length
        int index = 0;

        // Act
        boolean result = rule.patternAndContextMatches(input, index);

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testPatternAndContextMatches_PatternDoesNotMatch_ReturnsFalse() {
        // Arrange
        String pattern = "abc";
        Rule rule = new Rule(pattern, "", "", null);
        CharSequence input = "abcd"; // input matches the length but not the pattern
        int index = 0;

        // Act
        boolean result = rule.patternAndContextMatches(input, index);

        // Assert
        assertFalse(result);
    }

}