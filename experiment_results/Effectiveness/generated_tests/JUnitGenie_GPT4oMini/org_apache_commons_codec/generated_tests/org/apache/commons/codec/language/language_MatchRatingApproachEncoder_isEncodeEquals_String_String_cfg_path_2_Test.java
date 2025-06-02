package org.apache.commons.codec.language;
import org.apache.commons.codec.language.MatchRatingApproachEncoder;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_MatchRatingApproachEncoder_isEncodeEquals_String_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsEncodeEquals() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();

        // Test valid input strings
        String name1 = "Alexander";
        String name2 = "Alexandre";
        try {
            boolean result = encoder.isEncodeEquals(name1, name2);
            assertTrue(result);
        } catch (Exception e) {
            fail("Should not throw exception for valid input");
        }

        // Test with edge case strings that are both null
        name1 = null;
        name2 = null;
        try {
            boolean result = encoder.isEncodeEquals(name1, name2);
            assertFalse(result);
        } catch (Exception e) {
            fail("Should not throw exception for null inputs");
        }

        // Test with empty strings
        name1 = "";
        name2 = " ";
        try {
            boolean result = encoder.isEncodeEquals(name1, name2);
            assertFalse(result);
        } catch (Exception e) {
            fail("Should not throw exception for empty strings");
        }

        // Test with single character strings
        name1 = "A";
        name2 = "B";
        try {
            boolean result = encoder.isEncodeEquals(name1, name2);
            assertFalse(result);
        } catch (Exception e) {
            fail("Should not throw exception for single character inputs");
        }

        // Test with strings whose processed lengths differ by 3 or more
        name1 = "LongString";
        name2 = "VeryLongString";
        try {
            boolean result = encoder.isEncodeEquals(name1, name2);
            assertFalse(result);
        } catch (Exception e) {
            fail("Should not throw exception for length differing more than 3");
        }

        // Test with valid processed names
        name1 = "Jonathan";
        name2 = "Jonathon";
        try {
            boolean result = encoder.isEncodeEquals(name1, name2);
            assertTrue(result);
        } catch (Exception e) {
            fail("Should not throw exception for valid processed names");
        }
    }

}