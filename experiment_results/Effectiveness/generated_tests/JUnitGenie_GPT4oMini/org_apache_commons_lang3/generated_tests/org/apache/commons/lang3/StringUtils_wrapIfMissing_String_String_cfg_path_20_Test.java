package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_20_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNullStr() {
        String str = null;
        String wrapWith = "wrap";
        String result = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNullWrapWith() {
        String str = "test";
        String wrapWith = null;
        String result = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals("test", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNoWrapNeeded() {
        String str = "test";
        String wrapWith = "test";
        String result = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals("test", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithWrapStartOnly() {
        String str = "test";
        String wrapWith = "wrap";
        String result = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals("wraptest", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithWrapEndOnly() {
        String str = "test";
        String wrapWith = "wrap";
        String result = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals("testwrap", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithWrapBoth() {
        String str = "test";
        String wrapWith = "wrap";
        String result = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals("wraptestwrap", result);
    }

}