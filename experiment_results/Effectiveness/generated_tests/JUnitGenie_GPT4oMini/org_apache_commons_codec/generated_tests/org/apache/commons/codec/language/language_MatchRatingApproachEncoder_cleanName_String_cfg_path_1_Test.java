package org.apache.commons.codec.language;
import org.apache.commons.codec.language.MatchRatingApproachEncoder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class language_MatchRatingApproachEncoder_cleanName_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCleanName() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        String name = "John-Doe & Co.";
        String expected = "JOHNDOECO";
        
        try {
            String result = encoder.cleanName(name);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCleanNameWithNull() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        String name = null;

        try {
            String result = encoder.cleanName(name);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

}