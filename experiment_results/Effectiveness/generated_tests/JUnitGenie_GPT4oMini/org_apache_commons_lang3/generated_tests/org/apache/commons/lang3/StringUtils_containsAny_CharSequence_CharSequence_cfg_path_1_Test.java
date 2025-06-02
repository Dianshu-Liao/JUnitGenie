package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringUtils_containsAny_CharSequence_CharSequence_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testContainsAny_WithNullSearchChars() {
        CharSequence cs = "test";
        CharSequence searchChars = null;

        // The method should return false when searchChars is null
        boolean result = StringUtils.containsAny(cs, searchChars);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAny_WithEmptySearchChars() {
        CharSequence cs = "test";
        CharSequence searchChars = "";

        // The method should return false when searchChars is empty
        boolean result = StringUtils.containsAny(cs, searchChars);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAny_WithMatchingCharacters() {
        CharSequence cs = "test";
        CharSequence searchChars = "e";

        // The method should return true when searchChars contains a character present in cs
        boolean result = StringUtils.containsAny(cs, searchChars);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testContainsAny_WithNonMatchingCharacters() {
        CharSequence cs = "test";
        CharSequence searchChars = "xyz";

        // The method should return false when searchChars contains characters not present in cs
        boolean result = StringUtils.containsAny(cs, searchChars);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testContainsAny_WithMultipleMatchingCharacters() {
        CharSequence cs = "test";
        CharSequence searchChars = "st";

        // The method should return true when searchChars contains multiple characters present in cs
        boolean result = StringUtils.containsAny(cs, searchChars);
        assertTrue(result);
    }

}