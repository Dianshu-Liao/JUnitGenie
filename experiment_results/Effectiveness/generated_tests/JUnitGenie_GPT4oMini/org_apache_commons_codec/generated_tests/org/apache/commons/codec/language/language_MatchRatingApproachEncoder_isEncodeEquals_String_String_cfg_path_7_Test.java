package org.apache.commons.codec.language;
import org.apache.commons.codec.language.MatchRatingApproachEncoder;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_MatchRatingApproachEncoder_isEncodeEquals_String_String_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testIsEncodeEquals_NullName1() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        try {
            boolean result = encoder.isEncodeEquals(null, "test");
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsEncodeEquals_EmptyName1() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        try {
            boolean result = encoder.isEncodeEquals("", "test");
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsEncodeEquals_SpaceName1() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        try {
            boolean result = encoder.isEncodeEquals(" ", "test");
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsEncodeEquals_NullName2() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        try {
            boolean result = encoder.isEncodeEquals("test", null);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsEncodeEquals_EmptyName2() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        try {
            boolean result = encoder.isEncodeEquals("test", "");
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsEncodeEquals_SpaceName2() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        try {
            boolean result = encoder.isEncodeEquals("test", " ");
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsEncodeEquals_SingleCharacterNames() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        try {
            boolean result = encoder.isEncodeEquals("a", "b");
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsEncodeEquals_EqualNames() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();
        try {
            boolean result = encoder.isEncodeEquals("test", "test");
            assertTrue(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}