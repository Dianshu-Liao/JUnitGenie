package org.apache.commons.codec.language;
import org.apache.commons.codec.language.MatchRatingApproachEncoder;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_MatchRatingApproachEncoder_isEncodeEquals_String_String_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testIsEncodeEquals() {
        MatchRatingApproachEncoder encoder = new MatchRatingApproachEncoder();

        // Test when name1 is null
        assertFalse(encoder.isEncodeEquals(null, "Doe"));

        // Test when name2 is null
        assertFalse(encoder.isEncodeEquals("John", null));

        // Test when name1 is empty
        assertFalse(encoder.isEncodeEquals("", "Doe"));

        // Test when name2 is empty
        assertFalse(encoder.isEncodeEquals("John", ""));

        // Test when name1 is just a space
        assertFalse(encoder.isEncodeEquals(" ", "Doe"));

        // Test when name2 is just a space
        assertFalse(encoder.isEncodeEquals("John", " "));

        // Test when name1 length is 1
        assertFalse(encoder.isEncodeEquals("J", "Doe"));

        // Test when name2 length is 1
        assertFalse(encoder.isEncodeEquals("John", "D"));

        // Test when name1 and name2 are equal
        assertTrue(encoder.isEncodeEquals("John Doe", "john doe"));

        // Test when name1 and name2 are similar but with different lengths
        assertFalse(encoder.isEncodeEquals("Jonathon", "Jon"));

        // Test a valid scenario where names should be considered equal
        assertTrue(encoder.isEncodeEquals("Johnathan", "Jonathan"));
    }

}