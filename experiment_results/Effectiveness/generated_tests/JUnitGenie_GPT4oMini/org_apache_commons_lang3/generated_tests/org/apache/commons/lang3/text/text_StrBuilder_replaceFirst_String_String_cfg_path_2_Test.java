package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_StrBuilder_replaceFirst_String_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testReplaceFirst() {
        StrBuilder strBuilder = new StrBuilder("Hello World");
        String searchStr = "Hello";
        String replaceStr = "Hi";

        // Execute the focal method
        StrBuilder result = strBuilder.replaceFirst(searchStr, replaceStr);

        // Verify the result
        assertEquals("Hi World", result.toString());
    }

    @Test(timeout = 4000)
    public void testReplaceFirstWithEmptySearchString() {
        StrBuilder strBuilder = new StrBuilder("Hello World");
        String searchStr = "";
        String replaceStr = "Hi";

        // Execute the focal method
        StrBuilder result = strBuilder.replaceFirst(searchStr, replaceStr);

        // Verify the result remains unchanged
        assertEquals("Hello World", result.toString());
    }

    @Test(timeout = 4000)
    public void testReplaceFirstWithNullSearchString() {
        StrBuilder strBuilder = new StrBuilder("Hello World");
        String searchStr = null;
        String replaceStr = "Hi";

        try {
            // Execute the focal method
            strBuilder.replaceFirst(searchStr, replaceStr);
            fail("Expected an exception to be thrown due to null searchStr");
        } catch (Exception e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testReplaceFirstWithNonExistentSearchString() {
        StrBuilder strBuilder = new StrBuilder("Hello World");
        String searchStr = "Goodbye";
        String replaceStr = "Hi";

        // Execute the focal method
        StrBuilder result = strBuilder.replaceFirst(searchStr, replaceStr);

        // Verify the result remains unchanged
        assertEquals("Hello World", result.toString());
    }

}