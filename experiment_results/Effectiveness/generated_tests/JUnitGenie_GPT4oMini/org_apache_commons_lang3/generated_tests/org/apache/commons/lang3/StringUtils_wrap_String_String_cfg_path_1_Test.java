package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrap_String_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWrap() {
        String str = "test";
        String wrapWith = "*";
        
        // Testing the normal case where both parameters are non-empty
        String result = StringUtils.wrap(str, wrapWith);
        assertEquals("*test*", result);
    }

    @Test(timeout = 4000)
    public void testWrapWithEmptyString() {
        String str = "test";
        String wrapWith = "";
        
        // Testing when wrapWith is empty
        String result = StringUtils.wrap(str, wrapWith);
        assertEquals("test", result);
    }

    @Test(timeout = 4000)
    public void testWrapWithNullString() {
        String str = "test";
        String wrapWith = null;
        
        // Testing when wrapWith is null
        String result = StringUtils.wrap(str, wrapWith);
        assertEquals("test", result);
    }

    @Test(timeout = 4000)
    public void testWrapWithBothEmpty() {
        String str = "";
        String wrapWith = "";
        
        // Testing when both parameters are empty
        String result = StringUtils.wrap(str, wrapWith);
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testWrapWithBothNull() {
        String str = null;
        String wrapWith = null;
        
        // Testing when both parameters are null
        String result = StringUtils.wrap(str, wrapWith);
        assertEquals(null, result);
    }

}