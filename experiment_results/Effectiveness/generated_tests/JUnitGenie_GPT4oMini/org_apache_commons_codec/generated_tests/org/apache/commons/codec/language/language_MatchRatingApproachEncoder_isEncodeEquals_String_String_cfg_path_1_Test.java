package org.apache.commons.codec.language;
import org.apache.commons.codec.language.MatchRatingApproachEncoder;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_MatchRatingApproachEncoder_isEncodeEquals_String_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsEncodeEquals() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();

        // Test case where both names are valid and similar
        String name1 = "Edward";
        String name2 = "Edwrd";
        try {
            boolean result = encoder.isEncodeEquals(name1, name2);
            assertTrue(result);
        } catch (Exception e) {
            fail("Exception should not be thrown for valid inputs");
        }

        // Test case where one name is null
        name1 = null;
        name2 = "Edwrd";
        try {
            boolean result = encoder.isEncodeEquals(name1, name2);
            assertFalse(result);
        } catch (Exception e) {
            fail("Exception should not be thrown for null input");
        }

        // Test case where both names are empty
        name1 = "";
        name2 = "";
        try {
            boolean result = encoder.isEncodeEquals(name1, name2);
            assertFalse(result);
        } catch (Exception e) {
            fail("Exception should not be thrown for empty inputs");
        }

        // Test case where one name is a single character
        name1 = "E";
        name2 = "Edwrd";
        try {
            boolean result = encoder.isEncodeEquals(name1, name2);
            assertFalse(result);
        } catch (Exception e) {
            fail("Exception should not be thrown for single character input");
        }

        // Test case where names differ significantly
        name1 = "Edward";
        name2 = "John";
        try {
            boolean result = encoder.isEncodeEquals(name1, name2);
            assertFalse(result);
        } catch (Exception e) {
            fail("Exception should not be thrown for significantly different names");
        }

        // Test case where names are similar but with different casing
        name1 = "edward";
        name2 = "EDWARD";
        try {
            boolean result = encoder.isEncodeEquals(name1, name2);
            assertTrue(result);
        } catch (Exception e) {
            fail("Exception should not be thrown for case-insensitive match");
        }
    }

}