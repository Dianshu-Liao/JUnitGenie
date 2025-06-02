package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_defaultIfBlank_CharSequence_CharSequence_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testDefaultIfBlankWithNonBlankString() {
        CharSequence str = "Hello";
        CharSequence defaultStr = "Default";
        CharSequence result = StringUtils.defaultIfBlank(str, defaultStr);
        assertEquals("Hello", result);
    }

    @Test(timeout = 4000)
    public void testDefaultIfBlankWithBlankString() {
        CharSequence str = ""; // Blank string
        CharSequence defaultStr = "Default";
        CharSequence result = StringUtils.defaultIfBlank(str, defaultStr);
        assertEquals("Default", result);
    }

    @Test(timeout = 4000)
    public void testDefaultIfBlankWithNullString() {
        CharSequence str = null; // Null string
        CharSequence defaultStr = "Default";
        CharSequence result = StringUtils.defaultIfBlank(str, defaultStr);
        assertEquals("Default", result);
    }

    @Test(timeout = 4000)
    public void testDefaultIfBlankWithBothBlank() {
        CharSequence str = ""; // Blank string
        CharSequence defaultStr = ""; // Blank default
        CharSequence result = StringUtils.defaultIfBlank(str, defaultStr);
        assertEquals("", result);
    }

}