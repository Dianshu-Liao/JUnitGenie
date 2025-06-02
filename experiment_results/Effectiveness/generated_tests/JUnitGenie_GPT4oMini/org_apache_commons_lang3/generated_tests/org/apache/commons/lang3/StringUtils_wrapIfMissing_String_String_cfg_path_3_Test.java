package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNullStr() {
        String str = null; // External_Method_Parameters_Constraints: @parameter0 must be null
        String wrapWith = "[]";
        String expected = null; // Since str is null, the expected output is null
        String actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNullWrapWith() {
        String str = "test";
        String wrapWith = null; // External_Method_Parameters_Constraints: @parameter1 must be null
        String expected = "test"; // Since wrapWith is null, the expected output is the original string
        String actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNoWrapNeeded() {
        String str = "test";
        String wrapWith = "test"; // No wrapping needed
        String expected = "test"; // The expected output is the original string
        String actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithWrapNeeded() {
        String str = "test";
        String wrapWith = "[ ]"; // Wrapping needed
        String expected = "[ ]test[ ]"; // The expected output is the string wrapped
        String actual = StringUtils.wrapIfMissing(str, wrapWith);
        assertEquals(expected, actual);
    }

}