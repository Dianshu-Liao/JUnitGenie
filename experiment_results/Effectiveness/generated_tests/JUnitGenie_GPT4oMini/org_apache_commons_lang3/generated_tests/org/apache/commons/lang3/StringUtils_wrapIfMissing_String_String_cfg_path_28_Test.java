package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_28_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissing_BothEndsMissing() {
        String str = "example";
        String wrapWith = "*";
        String expected = "*example*";
        String actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_StartMissing() {
        String str = "example";
        String wrapWith = "*";
        String expected = "*example";
        String actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_EndMissing() {
        String str = "example";
        String wrapWith = "*";
        String expected = "example*";
        String actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_NeitherEndMissing() {
        String str = "*example*";
        String wrapWith = "*";
        String expected = "*example*";
        String actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_EmptyString() {
        String str = "";
        String wrapWith = "*";
        String expected = "";
        String actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_NullString() {
        String str = null;
        String wrapWith = "*";
        String expected = null;
        String actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_EmptyWrapWith() {
        String str = "example";
        String wrapWith = "";
        String expected = "example";
        String actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_NullWrapWith() {
        String str = "example";
        String wrapWith = null;
        String expected = "example";
        String actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);
    }

}