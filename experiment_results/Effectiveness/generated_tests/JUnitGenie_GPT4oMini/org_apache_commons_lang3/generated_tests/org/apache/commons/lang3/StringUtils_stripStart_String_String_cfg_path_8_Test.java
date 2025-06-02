package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_stripStart_String_String_cfg_path_8_Test {

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
    public void testStripStartWithNullStripChars() {
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
    public void testStripStartWithNoLeadingCharacters() {
        String str = "Hello World";
        String stripChars = "x";
        String expected = "Hello World";
        String result = StringUtils.stripStart(str, stripChars);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testStripStartWithAllCharactersStripped() {
        String str = "xxxx";
        String stripChars = "x";
        String expected = "";
        String result = StringUtils.stripStart(str, stripChars);
        assertEquals(expected, result);
    }

}