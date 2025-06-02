package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissing() {
        String str = "test";
        String wrapWith = "*";
        // Test the case when the string does not have the wrap characters
        String result = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals("*test*", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNullStr() {
        String str = null;
        String wrapWith = "*";
        // Test the case when str is null
        String result = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNullWrap() {
        String str = "test";
        String wrapWith = null;
        // Test the case when wrapWith is null
        String result = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals("test", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithEmptyStr() {
        String str = "";
        String wrapWith = "*";
        // Test the case when str is empty
        String result = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingAlreadyWrapped() {
        String str = "*test*";
        String wrapWith = "*";
        // Test the case when the string is already correctly wrapped
        String result = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals("*test*", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingOnlyStartWrap() {
        String str = "test";
        String wrapWith = "t";
        // Test the case when only the start of the string needs wrapping
        String result = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals("ttest", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingOnlyEndWrap() {
        String str = "test";
        String wrapWith = "t";
        // Test the case when only the end of the string needs wrapping
        String result = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals("testt", result);
    }

}