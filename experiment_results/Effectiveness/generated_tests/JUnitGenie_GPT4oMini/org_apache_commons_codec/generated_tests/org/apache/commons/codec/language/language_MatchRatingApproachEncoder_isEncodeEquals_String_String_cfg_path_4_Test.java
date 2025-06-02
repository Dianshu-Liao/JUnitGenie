package org.apache.commons.codec.language;
import org.apache.commons.codec.language.MatchRatingApproachEncoder;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class language_MatchRatingApproachEncoder_isEncodeEquals_String_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testIsEncodeEquals() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();

        // Test case where both names are equal
        String name1 = "John Doe";
        String name2 = "john doe";
        try {
            assertTrue(encoder.isEncodeEquals(name1, name2));
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Test case where names are not equal
        name1 = "John";
        name2 = "Doe";
        try {
            assertFalse(encoder.isEncodeEquals(name1, name2));
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Test case where one name is null
        name1 = null;
        name2 = "Doe";
        try {
            assertFalse(encoder.isEncodeEquals(name1, name2));
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Test case where both names are empty
        name1 = "";
        name2 = "";
        try {
            assertFalse(encoder.isEncodeEquals(name1, name2));
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Test case where one name is a single character
        name1 = "A";
        name2 = "B";
        try {
            assertFalse(encoder.isEncodeEquals(name1, name2));
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}