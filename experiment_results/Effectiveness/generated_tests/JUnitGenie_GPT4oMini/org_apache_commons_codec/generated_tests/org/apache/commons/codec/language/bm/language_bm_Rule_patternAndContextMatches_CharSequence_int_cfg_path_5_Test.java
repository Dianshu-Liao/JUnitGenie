package org.apache.commons.codec.language.bm;
import org.apache.commons.codec.language.bm.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_bm_Rule_patternAndContextMatches_CharSequence_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testPatternAndContextMatches() {
        // Arrange
        String pattern = "test";
        String leftContext = "context";
        String rightContext = "context";
        Rule rule = new Rule(pattern, leftContext, rightContext, null); // Assuming null for PhonemeExpr

        CharSequence input = "contexttestcontext";
        int index = 8; // The index where the pattern starts in the input

        // Act
        boolean result = rule.patternAndContextMatches(input, index);

        // Assert
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testPatternAndContextMatchesNegativeIndex() {
        // Arrange
        String pattern = "test";
        String leftContext = "context";
        String rightContext = "context";
        Rule rule = new Rule(pattern, leftContext, rightContext, null); // Assuming null for PhonemeExpr

        CharSequence input = "contexttestcontext";
        int index = -1; // Negative index to trigger exception

        // Act & Assert
        try {
            rule.patternAndContextMatches(input, index);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Can not match pattern at negative indexes", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testPatternAndContextMatchesInsufficientRoom() {
        // Arrange
        String pattern = "test";
        String leftContext = "context";
        String rightContext = "context";
        Rule rule = new Rule(pattern, leftContext, rightContext, null); // Assuming null for PhonemeExpr

        CharSequence input = "context";
        int index = 5; // Index where there is not enough room for the pattern

        // Act
        boolean result = rule.patternAndContextMatches(input, index);

        // Assert
        assertFalse(result);
    }

}