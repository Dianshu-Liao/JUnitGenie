package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_setNullText_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSetNullTextWithEmptyString() {
        StrBuilder strBuilder = new StrBuilder();
        String nullText = ""; // This will trigger the condition to set nullText to null

        try {
            strBuilder.setNullText(nullText);
            assertNull(strBuilder.getNullText()); // Use the getter method to verify that nullText is set to null
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSetNullTextWithNonEmptyString() {
        StrBuilder strBuilder = new StrBuilder();
        String nullText = "Some text"; // This will not trigger the condition

        try {
            strBuilder.setNullText(nullText);
            // Verify that nullText is set to "Some text"
            assertEquals("Some text", strBuilder.getNullText()); // Use the getter method to verify the value
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }


}