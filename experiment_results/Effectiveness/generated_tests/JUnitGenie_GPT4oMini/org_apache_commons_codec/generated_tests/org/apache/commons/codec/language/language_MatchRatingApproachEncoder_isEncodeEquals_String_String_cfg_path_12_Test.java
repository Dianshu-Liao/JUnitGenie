package org.apache.commons.codec.language;
import org.apache.commons.codec.language.MatchRatingApproachEncoder;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class language_MatchRatingApproachEncoder_isEncodeEquals_String_String_cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testIsEncodeEquals_Name1IsNull() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        String name1 = null;
        String name2 = "John Doe";
        try {
            boolean result = encoder.isEncodeEquals(name1, name2);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}