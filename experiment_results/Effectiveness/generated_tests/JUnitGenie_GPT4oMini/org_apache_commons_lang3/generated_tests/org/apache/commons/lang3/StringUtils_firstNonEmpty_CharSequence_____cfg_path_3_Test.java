package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

public class StringUtils_firstNonEmpty_CharSequence_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testFirstNonEmptyWithNullArray() {
        // Test case where the input is null
        CharSequence result = StringUtils.firstNonEmpty((CharSequence[]) null);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testFirstNonEmptyWithEmptyArray() {
        // Test case where the input is an empty array
        CharSequence result = StringUtils.firstNonEmpty(new CharSequence[]{});
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testFirstNonEmptyWithAllEmptyStrings() {
        // Test case where all elements are empty strings
        CharSequence result = StringUtils.firstNonEmpty(new CharSequence[]{"", "", ""});
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testFirstNonEmptyWithNonEmptyString() {
        // Test case where the first element is a non-empty string
        CharSequence result = StringUtils.firstNonEmpty(new CharSequence[]{"", "Hello", "World"});
        assertEquals("Hello", result.toString());
    }


}