package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_stripStart_String_String_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testStripStartWithLeadingWhitespace() {
        String str = "   Hello World";
        String stripChars = null;
        String expected = "Hello World";
        String result = StringUtils.stripStart(str, stripChars);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testStripStartWithLeadingCharacters() {
        String str = "xxHello World";
        String stripChars = "x";
        String expected = "Hello World";
        String result = StringUtils.stripStart(str, stripChars);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testStripStartWithEmptyString() {
        String str = "";
        String stripChars = null;
        String expected = "";
        String result = StringUtils.stripStart(str, stripChars);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testStripStartWithNullStripChars() {
        String str = "   ";
        String stripChars = null;
        String expected = "";
        String result = StringUtils.stripStart(str, stripChars);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testStripStartWithNullString() {
        String str = null;
        String stripChars = null;
        try {
            StringUtils.stripStart(str, stripChars);
        } catch (Exception e) {
            // Handle the exception as needed
        }
    }

}