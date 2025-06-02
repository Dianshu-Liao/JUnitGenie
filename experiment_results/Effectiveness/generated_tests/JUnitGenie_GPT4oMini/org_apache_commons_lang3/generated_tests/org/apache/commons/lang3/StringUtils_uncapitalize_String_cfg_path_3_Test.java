package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_uncapitalize_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testUncapitalize() {
        String input = "Hello"; // input that meets the constraints
        String expected = "hello"; // expected output after uncapitalization
        String actual = StringUtils.uncapitalize(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testUncapitalizeAlreadyLowercase() {
        String input = "hello"; // input that meets the constraints
        String expected = "hello"; // expected output remains the same
        String actual = StringUtils.uncapitalize(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testUncapitalizeEmptyString() {
        String input = ""; // input that meets the constraints
        String expected = ""; // expected output remains the same
        String actual = StringUtils.uncapitalize(input);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testUncapitalizeNull() {
        String input = null; // input that does not meet the constraints
        try {
            StringUtils.uncapitalize(input);
        } catch (Exception e) {
            // expected behavior, as input is null
        }
    }

}