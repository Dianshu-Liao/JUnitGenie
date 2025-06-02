package org.apache.commons.lang3;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.apache.commons.lang3.StringUtils;

public class StringUtils_stripStart_String_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testStripStart_withNonEmptyStringAndNonNullStripChars() {
        String input = "   Hello World";
        String stripChars = " ";
        String expected = "Hello World";
        
        String result = StringUtils.stripStart(input, stripChars);
        
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testStripStart_withNonEmptyStringAndNullStripChars() {
        String input = "   Hello World";
        String expected = "Hello World";
        
        String result = StringUtils.stripStart(input, null);
        
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testStripStart_withEmptyStripChars() {
        String input = "   Hello World";
        String stripChars = "";
        String expected = "   Hello World";
        
        String result = StringUtils.stripStart(input, stripChars);
        
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testStripStart_withStringContainingOnlyStripChars() {
        String input = "   ";
        String stripChars = " ";
        String expected = "";
        
        String result = StringUtils.stripStart(input, stripChars);
        
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testStripStart_withNullInput() {
        String input = null;
        String stripChars = " ";
        String expected = null;
        
        String result = StringUtils.stripStart(input, stripChars);
        
        assertEquals(expected, result);
    }
    
    @Test(timeout = 4000)
    public void testStripStart_withStringOfLengthZero() {
        String input = "";
        String stripChars = " ";
        String expected = "";
        
        String result = StringUtils.stripStart(input, stripChars);
        
        assertEquals(expected, result);
    }

}