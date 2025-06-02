package org.apache.commons.codec.language;
import org.apache.commons.codec.language.MatchRatingApproachEncoder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class language_MatchRatingApproachEncoder_removeVowels_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRemoveVowels() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        String input = "Hello World"; // Input that will go through the entire CFG path
        String expectedOutput = "Hll Wrld"; // Expected output after removing vowels
        String actualOutput = null;

        try {
            actualOutput = encoder.removeVowels(input);
        } catch (Exception e) {
            // Handle exception if necessary
            e.printStackTrace();
        }

        assertEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testRemoveVowelsWithFirstLetterVowel() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        String input = "Apple Pie"; // Input where first letter is a vowel
        String expectedOutput = "Apple P"; // Expected output after removing vowels
        String actualOutput = null;

        try {
            actualOutput = encoder.removeVowels(input);
        } catch (Exception e) {
            // Handle exception if necessary
            e.printStackTrace();
        }

        assertEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testRemoveVowelsWithNoVowels() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        String input = "Rhythm"; // Input with no vowels
        String expectedOutput = "Rhythm"; // Expected output should be the same
        String actualOutput = null;

        try {
            actualOutput = encoder.removeVowels(input);
        } catch (Exception e) {
            // Handle exception if necessary
            e.printStackTrace();
        }

        assertEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testRemoveVowelsWithEmptyString() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        String input = ""; // Empty input
        String expectedOutput = ""; // Expected output should be empty
        String actualOutput = null;

        try {
            actualOutput = encoder.removeVowels(input);
        } catch (Exception e) {
            // Handle exception if necessary
            e.printStackTrace();
        }

        assertEquals(expectedOutput, actualOutput);
    }

}