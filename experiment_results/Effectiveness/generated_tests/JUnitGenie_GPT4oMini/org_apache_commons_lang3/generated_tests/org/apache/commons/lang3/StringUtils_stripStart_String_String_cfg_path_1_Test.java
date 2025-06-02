package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_stripStart_String_String_cfg_path_1_Test {
    
    @Test(timeout = 4000)
    public void testStripStart_emptyString() {
        String str = "";
        String stripChars = " ";
        try {
            String result = StringUtils.stripStart(str, stripChars);
            assertEquals("", result);
        } catch (Exception e) {
            // Handle exception if any unexpected exception occurs
        }
    }

    @Test(timeout = 4000)
    public void testStripStart_leadingWhitespace() {
        String str = "   Hello World";
        String stripChars = null;
        try {
            String result = StringUtils.stripStart(str, stripChars);
            assertEquals("Hello World", result);
        } catch (Exception e) {
            // Handle exception if any unexpected exception occurs
        }
    }
    
    @Test(timeout = 4000)
    public void testStripStart_customStripChars() {
        String str = "xxHello World";
        String stripChars = "x";
        try {
            String result = StringUtils.stripStart(str, stripChars);
            assertEquals("Hello World", result);
        } catch (Exception e) {
            // Handle exception if any unexpected exception occurs
        }
    }
    
    @Test(timeout = 4000)
    public void testStripStart_nullString() {
        String str = null;
        String stripChars = null;
        try {
            String result = StringUtils.stripStart(str, stripChars);
            assertEquals(null, result);
        } catch (Exception e) {
            // Handle exception if any unexpected exception occurs
        }
    }
    
    @Test(timeout = 4000)
    public void testStripStart_emptyStripChars() {
        String str = "   Leading space";
        String stripChars = "";
        try {
            String result = StringUtils.stripStart(str, stripChars);
            assertEquals("   Leading space", result);
        } catch (Exception e) {
            // Handle exception if any unexpected exception occurs
        }
    }

}