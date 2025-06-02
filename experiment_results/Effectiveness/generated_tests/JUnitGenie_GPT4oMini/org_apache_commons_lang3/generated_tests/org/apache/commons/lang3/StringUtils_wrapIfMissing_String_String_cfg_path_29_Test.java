package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_29_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNonNullParameters() {
        String result = StringUtils.wrapIfMissing("text", "*");
        assertEquals("*text*", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithMissingStart() {
        String result = StringUtils.wrapIfMissing("text", "[");
        assertEquals("[text]", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithMissingEnd() {
        String result = StringUtils.wrapIfMissing("text", "]");
        assertEquals("text]", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithBothMissing() {
        String result = StringUtils.wrapIfMissing("text", "#");
        assertEquals("#text#", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithEmptyWrapWith() {
        String result = StringUtils.wrapIfMissing("text", "");
        assertEquals("text", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithEmptyString() {
        String result = StringUtils.wrapIfMissing("", "[");
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNullStr() {
        String result = StringUtils.wrapIfMissing(null, "*");
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNullWrapWith() {
        String result = StringUtils.wrapIfMissing("text", null);
        assertEquals("text", result);
    }

}