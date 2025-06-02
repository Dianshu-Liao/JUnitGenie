package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNullStr() {
        String str = null; // parameter0 must be null
        String wrapWith = "wrap"; // valid wrapWith
        String expected = null; // expected output when str is null
        String actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNullWrapWith() {
        String str = "test"; // valid str
        String wrapWith = null; // parameter1 must be null
        String expected = "test"; // expected output when wrapWith is null
        String actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNoWrapNeeded() {
        String str = "test"; // valid str
        String wrapWith = ""; // wrapWith is empty
        String expected = "test"; // expected output when wrapWith is empty
        String actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithWrapNeeded() {
        String str = "test"; // valid str
        String wrapWith = "wrap"; // valid wrapWith
        String expected = "wraptestwrap"; // expected output when wrapWith is needed
        String actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);
    }

}