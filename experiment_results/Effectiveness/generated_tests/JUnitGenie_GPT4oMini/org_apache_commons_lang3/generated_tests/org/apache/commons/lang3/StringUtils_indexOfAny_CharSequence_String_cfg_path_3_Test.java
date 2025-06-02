package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_indexOfAny_CharSequence_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIndexOfAny_WithNonEmptyCharSequenceAndEmptySearchChars() {
        CharSequence cs = "abc";
        String searchChars = "";
        try {
            int result = StringUtils.indexOfAny(cs, searchChars);
            assertEquals(-1, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIndexOfAny_WithEmptyCharSequenceAndNonEmptySearchChars() {
        CharSequence cs = "";
        String searchChars = "ab";
        try {
            int result = StringUtils.indexOfAny(cs, searchChars);
            assertEquals(-1, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIndexOfAny_WithNonEmptyCharSequenceAndNonEmptySearchChars() {
        CharSequence cs = "abc";
        String searchChars = "b";
        try {
            int result = StringUtils.indexOfAny(cs, searchChars);
            assertEquals(1, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIndexOfAny_WithNonEmptyCharSequenceAndNoMatchingSearchChars() {
        CharSequence cs = "abc";
        String searchChars = "xyz";
        try {
            int result = StringUtils.indexOfAny(cs, searchChars);
            assertEquals(-1, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}