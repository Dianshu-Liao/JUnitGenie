package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_lastIndexOf_CharSequence_int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testLastIndexOf_EmptySequence() {
        // Given
        CharSequence seq = ""; // An empty CharSequence
        int searchChar = 'a';
        int startPos = 0;

        // When
        int result = StringUtils.lastIndexOf(seq, searchChar, startPos);

        // Then
        assertEquals(-1, result); // Expecting -1 since the sequence is empty
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_NonEmptySequence() {
        // Given
        CharSequence seq = "banana"; // A non-empty CharSequence
        int searchChar = 'a';
        int startPos = 5;

        // When
        int result = StringUtils.lastIndexOf(seq, searchChar, startPos);

        // Then
        assertEquals(3, result); // Expecting 3, the last index of 'a' before position 5
    }

}