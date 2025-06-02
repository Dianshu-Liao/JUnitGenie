package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_hashCode__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHashCode() {
        // Test case where size is 0 (empty buffer)
        StrBuilder strBuilderEmpty = new StrBuilder();
        strBuilderEmpty.size = 0; // Set size to 0
        strBuilderEmpty.buffer = new char[0]; // Set buffer to empty char array
        int expectedHashEmpty = 0; // Expected hash code for empty buffer
        assertEquals(expectedHashEmpty, strBuilderEmpty.hashCode());

        // Test case where size is greater than 0
        StrBuilder strBuilderNonEmpty = new StrBuilder();
        strBuilderNonEmpty.size = 3; // Set size to 3
        strBuilderNonEmpty.buffer = new char[] {'a', 'b', 'c'}; // Set buffer to contain 'a', 'b', 'c'
        int expectedHashNonEmpty = 31 * (31 * 0 + 'c') + 'b'; // Calculate expected hash code
        expectedHashNonEmpty = 31 * expectedHashNonEmpty + 'a'; // Final expected hash code
        assertEquals(expectedHashNonEmpty, strBuilderNonEmpty.hashCode());
    }

}