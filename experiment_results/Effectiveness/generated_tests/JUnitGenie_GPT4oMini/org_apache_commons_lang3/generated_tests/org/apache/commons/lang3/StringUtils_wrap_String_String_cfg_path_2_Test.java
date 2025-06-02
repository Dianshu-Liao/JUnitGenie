package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrap_String_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWrapWithNonEmptyStrings() {
        String str = "test";
        String wrapWith = "*";
        String expected = "*test*";
        String actual = StringUtils.wrap(str, wrapWith);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testWrapWithEmptyString() {
        String str = "test";
        String wrapWith = "";
        String expected = "test"; // Since wrapWith is empty, it should return str
        String actual = StringUtils.wrap(str, wrapWith);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testWrapWithNullString() {
        String str = null;
        String wrapWith = "*";
        String expected = null; // Since str is null, it should return str
        String actual = StringUtils.wrap(str, wrapWith);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testWrapWithBothEmptyStrings() {
        String str = "";
        String wrapWith = "";
        String expected = ""; // Since both are empty, it should return str
        String actual = StringUtils.wrap(str, wrapWith);
        assertEquals(expected, actual);
    }

}