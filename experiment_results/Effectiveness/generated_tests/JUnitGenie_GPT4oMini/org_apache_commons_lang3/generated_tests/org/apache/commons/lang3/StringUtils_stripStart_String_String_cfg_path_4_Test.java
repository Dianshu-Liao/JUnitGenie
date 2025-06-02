package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_stripStart_String_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testStripStartWithNonEmptyStringAndNonNullStripChars() {
        String str = "   Hello World";
        String stripChars = " ";
        String expected = "Hello World";
        String result = StringUtils.stripStart(str, stripChars);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testStripStartWithNonEmptyStringAndNullStripChars() {
        String str = "   Hello World";
        String stripChars = null;
        String expected = "Hello World";
        String result = StringUtils.stripStart(str, stripChars);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testStripStartWithEmptyStripChars() {
        String str = "   Hello World";
        String stripChars = "";
        String expected = "   Hello World";
        String result = StringUtils.stripStart(str, stripChars);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testStripStartWithNoLeadingStripChars() {
        String str = "Hello World";
        String stripChars = " ";
        String expected = "Hello World";
        String result = StringUtils.stripStart(str, stripChars);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testStripStartWithAllStripChars() {
        String str = "   ";
        String stripChars = " ";
        String expected = "";
        String result = StringUtils.stripStart(str, stripChars);
        assertEquals(expected, result);
    }

}