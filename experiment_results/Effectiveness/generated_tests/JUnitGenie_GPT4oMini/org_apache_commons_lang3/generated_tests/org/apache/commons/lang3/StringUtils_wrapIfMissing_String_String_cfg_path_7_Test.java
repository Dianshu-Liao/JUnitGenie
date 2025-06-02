package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissing_BothParametersEmpty() {
        String result = StringUtils.wrapIfMissing("", "");
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_StringEmpty_WrapWithNotEmpty() {
        String result = StringUtils.wrapIfMissing("", "wrap");
        assertEquals("wrap", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_StringNotEmpty_WrapWithEmpty() {
        String result = StringUtils.wrapIfMissing("text", "");
        assertEquals("text", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_NeitherWrapped() {
        String result = StringUtils.wrapIfMissing("text", "wrap");
        assertEquals("wraptextwrap", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_OnlyStartWrapped() {
        String result = StringUtils.wrapIfMissing("textwrap", "wrap");
        assertEquals("wraptextwrap", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_OnlyEndWrapped() {
        String result = StringUtils.wrapIfMissing("wraptext", "wrap");
        assertEquals("wraptextwrap", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_NeitherWrappedWithNull() {
        String result = StringUtils.wrapIfMissing(null, "wrap");
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_NeitherWrappedWithNullWrap() {
        String result = StringUtils.wrapIfMissing("text", null);
        assertEquals("text", result);
    }

}