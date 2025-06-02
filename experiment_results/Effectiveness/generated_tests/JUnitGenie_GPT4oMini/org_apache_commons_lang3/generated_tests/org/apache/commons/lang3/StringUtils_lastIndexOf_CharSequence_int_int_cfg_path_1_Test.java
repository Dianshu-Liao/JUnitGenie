package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_lastIndexOf_CharSequence_int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testLastIndexOf() {
        // Given
        String seq = "hello world";
        int searchChar = 'o';
        int startPos = 10;

        // When
        int result = StringUtils.lastIndexOf(seq, searchChar, startPos);

        // Then
        assertEquals(7, result);
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_EmptyString() {
        // Given
        String seq = "";
        int searchChar = 'o';
        int startPos = 0;

        // When
        int result = StringUtils.lastIndexOf(seq, searchChar, startPos);

        // Then
        assertEquals(-1, result); // INDEX_NOT_FOUND is typically represented as -1
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_NullSequence() {
        // Given
        CharSequence seq = null;
        int searchChar = 'o';
        int startPos = 0;

        // When
        try {
            StringUtils.lastIndexOf(seq, searchChar, startPos);
        } catch (NullPointerException e) {
            // Then
            // Expected exception
        }
    }

}