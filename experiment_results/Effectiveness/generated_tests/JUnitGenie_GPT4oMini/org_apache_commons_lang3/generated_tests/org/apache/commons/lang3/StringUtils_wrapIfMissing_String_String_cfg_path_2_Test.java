package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNullStr() {
        String str = null; // @parameter0 must be null
        String wrapWith = "wrap"; // wrapWith can be any non-empty string

        String result = StringUtils.wrapIfMissing(str, wrapWith);
        
        // Since str is null, the result should be null as per the method's logic
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithNullWrapWith() {
        String str = "test"; // @parameter0 can be any non-empty string
        String wrapWith = null; // @parameter1 must be null

        String result = StringUtils.wrapIfMissing(str, wrapWith);
        
        // Since wrapWith is null, the result should be "test" as per the method's logic
        assertEquals("test", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithBothNonEmpty() {
        String str = "test"; // @parameter0 can be any non-empty string
        String wrapWith = "wrap"; // @parameter1 can be any non-empty string

        String result = StringUtils.wrapIfMissing(str, wrapWith);
        
        // Since str does not start or end with wrapWith, it should return "wraptestwrap"
        assertEquals("wraptestwrap", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissingWithStrAlreadyWrapped() {
        String str = "wraptestwrap"; // @parameter0 is already wrapped
        String wrapWith = "wrap"; // @parameter1 can be any non-empty string

        String result = StringUtils.wrapIfMissing(str, wrapWith);
        
        // Since str is already wrapped, it should return the same string
        assertEquals("wraptestwrap", result);
    }

}