package org.apache.commons.codec.language;
import org.apache.commons.codec.language.MatchRatingApproachEncoder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class language_MatchRatingApproachEncoder_removeVowels_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRemoveVowelsWithE() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        String input = "Eagle";
        String expectedOutput = "Eagl"; // 'E' is retained, vowels removed
        String actualOutput = encoder.removeVowels(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testRemoveVowelsWithNoVowels() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        String input = "Sky";
        String expectedOutput = "Sky"; // No vowels to remove
        String actualOutput = encoder.removeVowels(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testRemoveVowelsWithAllVowels() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        String input = "AEIOU";
        String expectedOutput = "A"; // Only 'A' is retained
        String actualOutput = encoder.removeVowels(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testRemoveVowelsWithSpaces() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        String input = " A E I O U ";
        String expectedOutput = " A "; // Only 'A' is retained, spaces are handled
        String actualOutput = encoder.removeVowels(input);
        assertEquals(expectedOutput, actualOutput);
    }

}