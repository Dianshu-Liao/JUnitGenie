package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_32_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNullStr() {
        String str = null; // @parameter0 must be null
        String wrapWith = "wrap"; // valid wrapWith
        String expected = null; // expected output when str is null
        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle exception if any
        }
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithEmptyWrapWith() {
        String str = "test"; // valid str
        String wrapWith = ""; // wrapWith is empty
        String expected = "test"; // expected output when wrapWith is empty
        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle exception if any
        }
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNoWrapNeeded() {
        String str = "test"; // valid str
        String wrapWith = "test"; // wrapWith is the same as str
        String expected = "test"; // expected output when no wrapping is needed
        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle exception if any
        }
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithWrapNeeded() {
        String str = "test"; // valid str
        String wrapWith = "wrap"; // valid wrapWith
        String expected = "wraptestwrap"; // expected output when wrapping is needed
        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle exception if any
        }
    }

}