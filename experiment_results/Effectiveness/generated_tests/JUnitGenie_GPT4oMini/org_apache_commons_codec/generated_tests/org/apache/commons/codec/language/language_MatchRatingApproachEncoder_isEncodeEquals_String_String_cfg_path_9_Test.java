package org.apache.commons.codec.language;
import org.apache.commons.codec.language.MatchRatingApproachEncoder;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class language_MatchRatingApproachEncoder_isEncodeEquals_String_String_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testIsEncodeEqualsWithNullName1() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        try {
            boolean result = encoder.isEncodeEquals(null, "test");
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsEncodeEqualsWithEmptyName1() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        try {
            boolean result = encoder.isEncodeEquals("", "test");
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsEncodeEqualsWithSpaceName1() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        try {
            boolean result = encoder.isEncodeEquals(" ", "test");
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsEncodeEqualsWithNullName2() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        try {
            boolean result = encoder.isEncodeEquals("test", null);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsEncodeEqualsWithEmptyName2() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        try {
            boolean result = encoder.isEncodeEquals("test", "");
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsEncodeEqualsWithSpaceName2() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        try {
            boolean result = encoder.isEncodeEquals("test", " ");
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsEncodeEqualsWithSingleCharacterNames() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        try {
            boolean result = encoder.isEncodeEquals("a", "b");
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}