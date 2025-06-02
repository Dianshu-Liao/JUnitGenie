package org.apache.commons.codec.language;
import org.apache.commons.codec.language.MatchRatingApproachEncoder;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_MatchRatingApproachEncoder_isEncodeEquals_String_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsEncodeEquals() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();

        // Test case where both names are null
        assertFalse(encoder.isEncodeEquals(null, null));

        // Test case where one name is null
        assertFalse(encoder.isEncodeEquals("John", null));
        assertFalse(encoder.isEncodeEquals(null, "Doe"));

        // Test case where one name is empty
        assertFalse(encoder.isEncodeEquals("", "Doe"));
        assertFalse(encoder.isEncodeEquals("John", ""));

        // Test case where both names are empty
        assertFalse(encoder.isEncodeEquals("", ""));

        // Test case where one name is a space
        assertFalse(encoder.isEncodeEquals(" ", "Doe"));
        assertFalse(encoder.isEncodeEquals("John", " "));

        // Test case where both names are single characters
        assertFalse(encoder.isEncodeEquals("J", "D"));
        assertFalse(encoder.isEncodeEquals("J", "J"));

        // Test case where names are equal
        assertTrue(encoder.isEncodeEquals("John", "john"));

        // Test case where names are similar but not equal
        assertTrue(encoder.isEncodeEquals("Johnathan", "John"));

        // Test case where names differ significantly
        assertFalse(encoder.isEncodeEquals("John", "Doe"));

        // Test case where names have different lengths
        assertFalse(encoder.isEncodeEquals("John", "Johnathan"));

        // Test case with valid names that will go through the cleaning and processing
        assertTrue(encoder.isEncodeEquals("Eleanor", "Eli"));
    }

}