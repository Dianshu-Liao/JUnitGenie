package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissing_NullString() {
        String str = null;
        String wrapWith = "wrap";
        String expected = null;

        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_NullWrapWith() {
        String str = "test";
        String wrapWith = null;
        String expected = "test";

        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_NoWrapNeeded() {
        String str = "test";
        String wrapWith = "test";
        String expected = "test";

        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_WrapStartOnly() {
        String str = "test";
        String wrapWith = "[";
        String expected = "[test";

        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_WrapEndOnly() {
        String str = "test";
        String wrapWith = "]";
        String expected = "test]";

        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_WrapBoth() {
        String str = "test";
        String wrapWith = "*";
        String expected = "*test*";

        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}