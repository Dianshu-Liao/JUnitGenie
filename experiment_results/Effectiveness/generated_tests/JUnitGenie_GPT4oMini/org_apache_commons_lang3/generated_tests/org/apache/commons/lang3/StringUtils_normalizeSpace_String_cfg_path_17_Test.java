package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_normalizeSpace_String_cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testNormalizeSpace_withNonEmptyString() {
        String input = "   Hello   World   ";
        String expected = "Hello World";
        String actual = StringUtils.normalizeSpace(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpace_withEmptyString() {
        String input = "";
        String expected = "";
        String actual = StringUtils.normalizeSpace(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpace_withOnlyWhitespaces() {
        String input = "     ";
        String expected = "";
        String actual = StringUtils.normalizeSpace(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpace_withNull() {
        String input = null;
        String expected = null;
        String actual = StringUtils.normalizeSpace(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testNormalizeSpace_withNonWhitespaceCharacters() {
        String input = "Hello\tWorld\n";
        String expected = "Hello World";
        String actual = StringUtils.normalizeSpace(input);
        assertEquals(expected, actual);
    }

}