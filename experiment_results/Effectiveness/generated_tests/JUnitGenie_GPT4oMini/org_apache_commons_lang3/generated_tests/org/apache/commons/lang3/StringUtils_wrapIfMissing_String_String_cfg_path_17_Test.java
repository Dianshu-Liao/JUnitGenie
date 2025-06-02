package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNullStr() {
        String str = null; // @parameter0 must be null
        String wrapWith = "[]";
        String expected = null; // Since str is null, the expected output is also null

        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNullWrapWith() {
        String str = "test"; // A valid string
        String wrapWith = null; // @parameter1 must be null
        String expected = "test"; // Since wrapWith is null, the expected output is the original string

        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNoWrapNeeded() {
        String str = "test"; // A valid string
        String wrapWith = "test"; // The string to wrap with
        String expected = "test"; // Since str already starts and ends with wrapWith, the expected output is the original string

        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithWrapNeeded() {
        String str = "test"; // A valid string
        String wrapWith = "["; // The string to wrap with
        String expected = "[test]"; // The expected output after wrapping

        try {
            String result = StringUtils.wrapIfMissing(str, wrapWith);
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}