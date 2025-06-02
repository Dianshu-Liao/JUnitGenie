package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_19_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNullStr() {
        String str = null;
        String wrapWith = "wrap";
        String expected = null;

        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNullWrapWith() {
        String str = "test";
        String wrapWith = null;
        String expected = "test";

        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNoWrapNeeded() {
        String str = "test";
        String wrapWith = "test";
        String expected = "test";

        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithWrapNeeded() {
        String str = "test";
        String wrapWith = "wrap";
        String expected = "wraptestwrap";

        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}