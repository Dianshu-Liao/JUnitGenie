package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.LocaleUtils;
import org.junit.Test;
import java.util.Locale;
import static org.junit.Assert.assertEquals;

public class StringUtils_lowerCase_String_Locale_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testLowerCaseWithValidInput() {
        String input = "HELLO WORLD";
        Locale locale = Locale.ENGLISH;
        String expected = "hello world";
        String result = StringUtils.lowerCase(input, locale);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testLowerCaseWithNullString() {
        String input = null;
        Locale locale = Locale.ENGLISH;
        String result = StringUtils.lowerCase(input, locale);
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testLowerCaseWithDifferentLocale() {
        String input = "HELLO WORLD";
        Locale locale = Locale.FRENCH;
        String expected = "hello world"; // Assuming LocaleUtils.toLocale(locale) returns a locale that does not affect the string
        String result = StringUtils.lowerCase(input, locale);
        assertEquals(expected, result);
    }

}