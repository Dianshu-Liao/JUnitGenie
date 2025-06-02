package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_wrapIfMissing_String_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWrapIfMissing_WithNonEmptyStringAndWrap() {
        String str = "hello";
        String wrapWith = "*";
        
        String result = StringUtils.wrapIfMissing(str, wrapWith);
        
        assertEquals("*hello*", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_WithStartMissing() {
        String str = "world";
        String wrapWith = "#";
        
        String result = StringUtils.wrapIfMissing(str, wrapWith);
        
        assertEquals("#world#", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_WithEndMissing() {
        String str = "test";
        String wrapWith = "$";
        
        String result = StringUtils.wrapIfMissing(str, wrapWith);
        
        assertEquals("$test$", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_WithBothWrapsMissing() {
        String str = "sample";
        String wrapWith = "@";
        
        String result = StringUtils.wrapIfMissing(str, wrapWith);
        
        assertEquals("@sample@", result);
    }

    @Test(timeout = 4000)
    public void testWrapIfMissing_WithNullString() {
        String str = null;
        String wrapWith = "$";
        
        String result = StringUtils.wrapIfMissing(str, wrapWith);
        
        assertEquals(null, result);
    }
    
    @Test(timeout = 4000)
    public void testWrapIfMissing_WithNullWrap() {
        String str = "content";
        String wrapWith = null;
        
        String result = StringUtils.wrapIfMissing(str, wrapWith);
        
        assertEquals("content", result);
    }

}