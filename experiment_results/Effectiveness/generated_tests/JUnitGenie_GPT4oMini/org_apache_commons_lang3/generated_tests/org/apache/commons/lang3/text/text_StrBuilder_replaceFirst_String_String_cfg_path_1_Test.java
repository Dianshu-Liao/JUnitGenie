package org.apache.commons.lang3.text;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_StrBuilder_replaceFirst_String_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testReplaceFirst() {
        StrBuilder strBuilder = new StrBuilder("Hello World");
        String searchStr = "World";
        String replaceStr = "Java";
        
        // Testing path where searchStr is found and gets replaced
        StrBuilder result = strBuilder.replaceFirst(searchStr, replaceStr);
        assertEquals("Hello Java", result.toString());
    }
    
    @Test(timeout = 4000)
    public void testReplaceFirstWhenSearchStrNotFound() {
        StrBuilder strBuilder = new StrBuilder("Hello World");
        String searchStr = "Python"; // Not present
        String replaceStr = "Java";
        
        // Testing path where searchStr is not found, no replacement should occur
        StrBuilder result = strBuilder.replaceFirst(searchStr, replaceStr);
        assertEquals("Hello World", result.toString());
    }

    @Test(timeout = 4000)
    public void testReplaceFirstWithEmptySearchStr() {
        StrBuilder strBuilder = new StrBuilder("Hello World");
        String searchStr = ""; // Edge case: empty string
        String replaceStr = "Java";
        
        // Searching with an empty search string should not result in changes
        StrBuilder result = strBuilder.replaceFirst(searchStr, replaceStr);
        assertEquals("Hello World", result.toString());
    }

    @Test(timeout = 4000)
    public void testReplaceFirstWithNullSearchStr() {
        StrBuilder strBuilder = new StrBuilder("Hello World");
        String searchStr = null; // Edge case: null search string
        String replaceStr = "Java";
        
        // Expect no exception, but nothing should be replaced
        try {
            StrBuilder result = strBuilder.replaceFirst(searchStr, replaceStr);
            assertEquals("Hello World", result.toString());
        } catch (Exception e) {
            fail("Should not throw an exception");
        }
    }

    @Test(timeout = 4000)
    public void testReplaceFirstWithNullReplaceStr() {
        StrBuilder strBuilder = new StrBuilder("Hello World");
        String searchStr = "World";
        String replaceStr = null; // Edge case: null replace string
        
        // Testing replacement with a null replace string
        StrBuilder result = strBuilder.replaceFirst(searchStr, replaceStr);
        assertEquals("Hello ", result.toString());
    }

}