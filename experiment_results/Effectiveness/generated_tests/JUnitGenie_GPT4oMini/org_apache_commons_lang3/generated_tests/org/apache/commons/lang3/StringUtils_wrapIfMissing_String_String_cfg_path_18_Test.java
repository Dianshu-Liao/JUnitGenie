package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_18_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissing_BothParametersEmpty() {
        String result = StringUtils.wrapIfMissing("", "");
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_StringEmpty_WrapWithNotEmpty() {
        String result = StringUtils.wrapIfMissing("", "wrap");
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_StringNotEmpty_WrapWithEmpty() {
        String result = StringUtils.wrapIfMissing("test", "");
        assertEquals("test", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_StringNotWrapped() {
        String result = StringUtils.wrapIfMissing("test", "wrap");
        assertEquals("wraptestwrap", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_StringAlreadyWrapped() {
        String result = StringUtils.wrapIfMissing("wraptestwrap", "wrap");
        assertEquals("wraptestwrap", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_StringStartsWithWrap() {
        String result = StringUtils.wrapIfMissing("wraptest", "wrap");
        assertEquals("wraptestwrap", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_StringEndsWithWrap() {
        String result = StringUtils.wrapIfMissing("testwrap", "wrap");
        assertEquals("wraptestwrap", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_NullString() {
        String result = StringUtils.wrapIfMissing(null, "wrap");
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_NullWrapWith() {
        String result = StringUtils.wrapIfMissing("test", null);
        assertEquals("test", result);
    }

}