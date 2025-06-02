package org.apache.commons.codec.language.bm;
import org.apache.commons.codec.language.bm.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_bm_Rule_patternAndContextMatches_CharSequence_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testPatternAndContextMatches() {
        // Arrange
        String pattern = "test";
        String input = "testing";
        int index = 0;
        Rule rule = new Rule(pattern, "", "", null); // Assuming other parameters can be null for this test

        // Act
        boolean result = rule.patternAndContextMatches(input, index);

        // Assert
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testPatternAndContextMatchesNegativeIndex() {
        // Arrange
        String pattern = "test";
        String input = "testing";
        int index = -1;
        Rule rule = new Rule(pattern, "", "", null); // Assuming other parameters can be null for this test

        // Act & Assert
        try {
            rule.patternAndContextMatches(input, index);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Can not match pattern at negative indexes", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testPatternAndContextMatchesInsufficientLength() {
        // Arrange
        String pattern = "test";
        String input = "te";
        int index = 0;
        Rule rule = new Rule(pattern, "", "", null); // Assuming other parameters can be null for this test

        // Act
        boolean result = rule.patternAndContextMatches(input, index);

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testPatternAndContextMatchesPatternMismatch() {
        // Arrange
        String pattern = "test";
        String input = "testing";
        int index = 0;
        Rule rule = new Rule(pattern, "", "", null); // Assuming other parameters can be null for this test

        // Act
        boolean result = rule.patternAndContextMatches(input, index);

        // Assert
        assertFalse(result);
    }

}