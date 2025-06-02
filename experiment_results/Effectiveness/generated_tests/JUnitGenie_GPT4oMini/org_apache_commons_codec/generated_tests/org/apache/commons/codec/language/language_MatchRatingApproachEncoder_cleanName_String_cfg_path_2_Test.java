package org.apache.commons.codec.language;
import org.apache.commons.codec.language.MatchRatingApproachEncoder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class language_MatchRatingApproachEncoder_cleanName_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCleanName() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        String input = "John-Doe & Co.";
        String expectedOutput = "JOHNDOECO"; // Expected output after cleaning

        try {
            String result = encoder.cleanName(input);
            assertEquals(expectedOutput, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCleanNameWithEmptyString() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        String input = "";
        String expectedOutput = ""; // Expected output for empty input

        try {
            String result = encoder.cleanName(input);
            assertEquals(expectedOutput, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCleanNameWithNull() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        String input = null;

        try {
            encoder.cleanName(input);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}